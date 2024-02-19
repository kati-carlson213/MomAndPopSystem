import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;


public class createAccountPage extends JPanel {
    Login login = new Login();
    Variables variableObj = new Variables();
    public createAccountPage(MainFrame mainFrame) {
        setLayout(null);

        this.variableObj = mainFrame.variableObj;
        this.login = mainFrame.login;

        Hashing hashing = new Hashing();


        JTextField firstNameInput = new JTextField();
        JTextField lastNameInput = new JTextField();
        JTextField emailInput = new JTextField();
        JTextField phoneNumInput = new JTextField();
        JTextField addressInput = new JTextField();

        JTextField usernameInput = new JTextField();
        JTextField passwordInput = new JTextField();

        JLabel usernameLabel = new JLabel("Input Username: ");
        JLabel passwordLabel = new JLabel("Input Password: ");


        JButton submitButton = new JButton();
        JButton mainPageButton = new JButton();
        JButton orderPageButton = new JButton();
        JButton aboutUsPageButton = new JButton();
        JButton MenuPageButton = new JButton();
        JLabel createAccountBackground = new JLabel();



        firstNameInput.setForeground(new java.awt.Color(102, 102, 102));
        add(firstNameInput);
        firstNameInput.setBounds(320, 190, 340, 35);


        lastNameInput.setForeground(new java.awt.Color(102, 102, 102));
        add(lastNameInput);
        lastNameInput.setBounds(320, 250, 340, 35);


        emailInput.setForeground(new java.awt.Color(102, 102, 102));
        add(emailInput);
        emailInput.setBounds(320, 300, 340, 35);

        phoneNumInput.setForeground(new java.awt.Color(102, 102, 102));
        add(phoneNumInput);
        phoneNumInput.setBounds(320, 360, 340, 35);


        addressInput.setForeground(new java.awt.Color(102, 102, 102));
        add(addressInput);
        addressInput.setBounds(320, 410, 340, 35);




        usernameInput.setBounds(180, 470, 300, 35);
        add(usernameInput);

        usernameLabel.setBounds(15, 470,  300, 35);
        usernameLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 18));
        usernameLabel.setForeground(new java.awt.Color(144, 0, 0));
        add(usernameLabel);

        passwordInput.setBounds(180, 530, 300, 35);
        add(passwordInput);

        passwordLabel.setBounds(15, 530,  300, 35);
        passwordLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 18));
        passwordLabel.setForeground(new java.awt.Color(144, 0, 0));
        add(passwordLabel);




        submitButton.setBackground(new java.awt.Color(242, 242, 242));
        submitButton.setFont(new java.awt.Font("Gill Sans MT", 3, 24));
        submitButton.setForeground(new java.awt.Color(144, 0, 0));
        submitButton.setText("Submit");
        submitButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));


        submitButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                String first =  firstNameInput.getText();
                String last  =  lastNameInput.getText();
                String email = emailInput.getText();
                String phone = phoneNumInput.getText();
                String street = addressInput.getText();
                String username = usernameInput.getText();
                String password = passwordInput.getText();



                GetUsernamesFromDatabase getInfo = new  GetUsernamesFromDatabase(mainFrame, username, login, variableObj);

                if (variableObj.getUsernameTaken() == true) {
                    JOptionPane.showMessageDialog(mainFrame, "The username you inputted is taken. Try again.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                else if ((username.equals("") || username.isEmpty()) && (password.equals("")  || password.isEmpty())){
                    JOptionPane.showMessageDialog(mainFrame, "Please insert an username and password!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                else if (username.equals("") || username.isEmpty()) {
                    JOptionPane.showMessageDialog(mainFrame, "Please insert an username!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                else if (password.equals("") || password.isEmpty()) {
                    JOptionPane.showMessageDialog(mainFrame, "Please insert a password!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    byte[] salt = hashing.generateSalt();
                    String hashedPassword = hashing.hashPassword(password, salt);
                    String saltString = Base64.getEncoder().encodeToString(salt);

                    InsertLoginInfoIntoDatabase database = new InsertLoginInfoIntoDatabase(mainFrame, username, hashedPassword, saltString, login);
                    InsertAccountInfoIntoDatabase account = new InsertAccountInfoIntoDatabase(mainFrame, first, last, email, phone, street);

                    login.wasLoginSuccessful(true);


                    mainFrame.showLoginPage();

                }



            }
        });

        add(submitButton);
        submitButton.setBounds(500, 490, 150, 70);


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

        orderPageButton.setBackground(new java.awt.Color(144, 0, 0));
        orderPageButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        orderPageButton.setForeground(new java.awt.Color(255, 255, 255));
        orderPageButton.setText("Order Page");


        orderPageButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showPizzaBuilderPage();
            }
        });

        add(orderPageButton);
        orderPageButton.setBounds(340, 30, 160, 32);

        aboutUsPageButton.setBackground(new java.awt.Color(144, 0, 0));
        aboutUsPageButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        aboutUsPageButton.setForeground(new java.awt.Color(255, 255, 255));
        aboutUsPageButton.setText("About Us");

        //click button
        aboutUsPageButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showAboutPage();
            }
        });

        add(aboutUsPageButton);
        aboutUsPageButton.setBounds(530, 30, 140, 32);

        MenuPageButton.setBackground(new java.awt.Color(144, 0, 0));
        MenuPageButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        MenuPageButton.setForeground(new java.awt.Color(255, 255, 255));
        MenuPageButton.setText("Menu");

        //click button
        MenuPageButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showMenuPage();
            }
        });

        add(MenuPageButton);
        MenuPageButton.setBounds(200, 30, 108, 32);

        createAccountBackground.setIcon(new javax.swing.ImageIcon("momPop_Background13.png"));
        add(createAccountBackground);
        createAccountBackground.setBounds(0, 0, 700, 600);
    }
}
