import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DecimalFormat;
import java.util.List;

public class accountInfoPage extends JPanel {
    Login login = new Login();
    Variables variableObj = new Variables();

    public accountInfoPage(MainFrame mainFrame) {
        this.variableObj = mainFrame.variableObj;
        this.login = mainFrame.login;


        JButton mainPageButton = new JButton();
        JButton menuButton = new JButton();
        JButton orderButton = new JButton();
        JButton aboutButton= new JButton();
        JButton logoutButton = new JButton();
        JLabel accountInfoBackground = new JLabel();


        JLabel firstNameLabel = new JLabel();
        JLabel lastNameLabel = new JLabel();
        JLabel emailLabel = new JLabel();
        JLabel  phoneLabel = new JLabel();
        JLabel addressLabel = new JLabel();



        setLayout(null);



        //when the page becomes visible
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (login.getLoginStatus()==true) {
                    GetAccountInfoFromDatabase getInfo = new GetAccountInfoFromDatabase(mainFrame, login, variableObj);


                    mainPageButton.setBackground(new java.awt.Color(144, 0, 0));
                    mainPageButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
                    mainPageButton.setForeground(new java.awt.Color(255, 255, 255));
                    mainPageButton.setText("Main Page");

                    //click button
                    mainPageButton.addActionListener( new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            mainFrame.showMainPage();
                        }
                    });

                    add(mainPageButton);
                    mainPageButton.setBounds(30, 30, 120, 32);

                    menuButton.setBackground(new java.awt.Color(144, 0, 0));
                    menuButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
                    menuButton.setForeground(new java.awt.Color(255, 255, 255));
                    menuButton.setText("Menu");

                    //click button
                    menuButton.addActionListener( new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            mainFrame.showMenuPage();
                        }
                    });

                    add(menuButton);
                    menuButton.setBounds(200, 30, 108, 32);

                    orderButton.setBackground(new java.awt.Color(144, 0, 0));
                    orderButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
                    orderButton.setForeground(new java.awt.Color(255, 255, 255));
                    orderButton.setText("Order Info");

                    //click button
                    orderButton.addActionListener( new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            mainFrame.showOrderInfoPage();
                        }
                    });

                    add(orderButton);
                    orderButton.setBounds(340, 30, 160, 32);

                    aboutButton.setBackground(new java.awt.Color(144, 0, 0));
                    aboutButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
                    aboutButton.setForeground(new java.awt.Color(255, 255, 255));
                    aboutButton.setText("About Us");

                    //click button
                    aboutButton.addActionListener( new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            mainFrame.showAboutPage();
                        }
                    });

                    add(aboutButton);
                    aboutButton.setBounds(530, 30, 140, 32);


                    firstNameLabel.setFont(new java.awt.Font("Segoe UI", 2, 18));
                    String firstName =  variableObj.getFirstName();;





                    firstNameLabel.setText(firstName);
                    add(firstNameLabel);
                    firstNameLabel.setBounds(280, 190, 380, 25);

                    lastNameLabel.setFont(new java.awt.Font("Segoe UI", 2, 18));
                    String lastName =  variableObj.getLastName();;

                    lastNameLabel.setText(lastName);
                    add(lastNameLabel);
                    lastNameLabel.setBounds(280, 240, 380, 25);


                    emailLabel.setFont(new java.awt.Font("Segoe UI", 2, 18));
                    String email =  variableObj.getEmailAddress();;

                    emailLabel.setText(email);
                    add(emailLabel);
                    emailLabel.setBounds(280, 290, 400, 25);


                    phoneLabel.setFont(new java.awt.Font("Segoe UI", 2, 18));
                    String phone = variableObj.getPhoneNum();

                    phoneLabel.setText(phone);
                    add(phoneLabel);
                    phoneLabel.setBounds(280, 340, 360, 25);


                    addressLabel.setFont(new java.awt.Font("Segoe UI", 2, 18));
                    String address = variableObj.getStreetAddress();

                    addressLabel.setText(address);
                    add(addressLabel);
                    addressLabel.setBounds(280, 395, 400, 25);





                    logoutButton.setBackground(new java.awt.Color(242, 242, 242));
                    logoutButton.setFont(new java.awt.Font("Segoe UI", 3, 24));
                    logoutButton.setForeground(new java.awt.Color(144, 0, 0));
                    logoutButton.setText("Logout");
                    logoutButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));

                    //click button
                    logoutButton.addActionListener( new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            login.wasLoginSuccessful(false);
                            login.setID(" ");
                            mainFrame.showMainPage();

                        }
                    });

                    add(logoutButton);
                    logoutButton.setBounds(533, 530, 130, 36);

                    accountInfoBackground.setIcon(new javax.swing.ImageIcon("momPop_Background14.png"));
                    add(accountInfoBackground);
                    accountInfoBackground.setBounds(0, -30, 710, 670);
                }


            }
        });








    }
}
