import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class pizzaBuilderPage extends JPanel {

    Variables variableObj = new Variables();

    Login login = new Login();
    public pizzaBuilderPage(MainFrame mainFrame) {

        this.variableObj = mainFrame.variableObj;
        this.login = mainFrame.login;


        setLayout(null);


        JButton menuButton = new JButton();
        JButton orderButton = new JButton();
        JButton aboutButton = new JButton();
        JButton accountButton = new JButton();
        JButton  continueButton = new JButton();
        JButton backButton = new JButton();
        JCheckBox thinCheck = new JCheckBox();
        JCheckBox regularCheck = new JCheckBox();
        JCheckBox panCheck = new JCheckBox();

        ButtonGroup pizzaBuilderBG = new ButtonGroup();
        pizzaBuilderBG.add(thinCheck);
        pizzaBuilderBG.add(regularCheck);
        pizzaBuilderBG.add(panCheck);



        menuButton.setBackground(new java.awt.Color(0, 0, 0));
        menuButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
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
        menuButton.setBounds(220, 170, 90, 30);


        orderButton.setBackground(new java.awt.Color(0, 0, 0));
        orderButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
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
        orderButton.setBounds(330, 170, 90, 30);

        aboutButton.setBackground(new java.awt.Color(0, 0, 0));
        aboutButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
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
        aboutButton.setBounds(440, 170, 108, 30);

        accountButton.setBackground(new java.awt.Color(0, 0, 0));
        accountButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
        accountButton.setForeground(new java.awt.Color(255, 255, 255));
        accountButton.setText("Account");


        //click button
        accountButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (login.getLoginStatus()==false) {
                    mainFrame.showLoginPage();
                }
                else {
                    mainFrame.showAccInfoPage();
                }

            }
        });


        add(accountButton);
        accountButton.setBounds(570, 170, 108, 30);

        continueButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        continueButton.setForeground(new java.awt.Color(144, 0, 0));
        continueButton.setText("Continue");
        continueButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(144, 0, 0), 2, true));

        //click button
        continueButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showPickSizePage();
              }
        });

        add(continueButton);
        continueButton.setBounds(140, 490, 170, 60);

        backButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        backButton.setForeground(new java.awt.Color(144, 0, 0));
        backButton.setText("Back to Main");
        backButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));

        //click button
        backButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showMainPage();
            }
        });

        add(backButton);
        backButton.setBounds(360, 490, 190, 60);

        thinCheck.setBackground(new java.awt.Color(144, 0, 0));
        thinCheck.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 28));
        thinCheck.setForeground(new java.awt.Color(255, 255, 255));
        thinCheck.setText("Thin");


        //check
        thinCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               variableObj.setCrustType("Thin");
            }
        });


        add(thinCheck);
        thinCheck.setBounds(90, 360, 130, 80);

        regularCheck.setBackground(new java.awt.Color(144, 0, 0));
        regularCheck.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 28));
        regularCheck.setForeground(new java.awt.Color(255, 255, 255));
        regularCheck.setText("Regular");
        regularCheck.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));

        //check
        regularCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                variableObj.setCrustType("Regular");

            }
        });

        add(regularCheck);
        regularCheck.setBounds(260, 360, 190, 80);

        panCheck.setBackground(new java.awt.Color(144, 0, 0));
        panCheck.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 28));
        panCheck.setForeground(new java.awt.Color(255, 255, 255));
        panCheck.setText("Pan");

        //check
        panCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                variableObj.setCrustType("Pan");
            }
        });

        add(panCheck);
        panCheck.setBounds(490, 360, 120, 80);


        JLabel builderBackground = new JLabel(new ImageIcon("momPop_Background4.png"));
        add(builderBackground);
        builderBackground.setBounds(0, 0, 700, 600);



    }
}
