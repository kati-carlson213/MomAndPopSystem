import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class sidesPage extends JPanel {
    Variables variableObj = new Variables();
    Login login = new Login();


    public sidesPage (MainFrame mainFrame) {
        this.variableObj = mainFrame.variableObj;
        this.login = mainFrame.login;

        JButton menuButton = new JButton();
        JButton orderButton = new JButton();
        JButton aboutButton = new JButton();
        JButton accountButton = new JButton();
        JButton continueButton = new JButton();
        JButton backButton = new JButton();
        JTextField breadsticksAmount = new JTextField();
        JTextField  breadsticksBitesAmount = new JTextField();
        JTextField cookieAmount = new JTextField();
        JLabel sidesBackground = new JLabel();

        setLayout(null);

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
        menuButton.setBounds(40, 40, 108, 32);

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
        orderButton.setBounds(190, 40, 160, 32);

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
        aboutButton.setBounds(380, 40, 140, 32);

        accountButton.setBackground(new java.awt.Color(144, 0, 0));
        accountButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
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
        accountButton.setBounds(550, 40, 108, 32);



        breadsticksAmount.setText("");

        breadsticksAmount.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSticksAmount();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSticksAmount();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSticksAmount();
            }

            private void updateSticksAmount() {
                String breadsticks = breadsticksAmount.getText();

                if (breadsticks.matches("-?\\d+(\\.\\d+)?")) {
                    int breadstickAmount = Integer.parseInt(breadsticks);
                    variableObj.setBreadSticksAmount(breadstickAmount);
                }
                else {
                    variableObj.setBreadSticksAmount(0);
                }


            }
        });


        add(breadsticksAmount);
        breadsticksAmount.setBounds(100, 280, 90, 30);

        breadsticksBitesAmount.setText("");
        breadsticksBitesAmount.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateBitesAmount();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateBitesAmount();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateBitesAmount();
            }

            private void updateBitesAmount() {
                String breadstickBites = breadsticksBitesAmount.getText();

                if (breadstickBites.matches("-?\\d+(\\.\\d+)?")) {
                    int bitesAmount = Integer.parseInt(breadstickBites);
                    variableObj.setBreadstickBitesAmount(bitesAmount);
                }
                else {
                    variableObj.setBreadstickBitesAmount(0);
                }
            }
        });

        add(breadsticksBitesAmount);
        breadsticksBitesAmount.setBounds(270, 440, 80, 35);

        cookieAmount.setText("");
        cookieAmount.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCookieAmount();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCookieAmount();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCookieAmount();
            }

            private void updateCookieAmount() {
                String cookies = cookieAmount.getText();

                if (cookies.matches("-?\\d+(\\.\\d+)?")) {
                    int cookieAmount = Integer.parseInt(cookies);
                    variableObj.setChipCookieAmount(cookieAmount);
                }
                else {
                    variableObj.setChipCookieAmount(0);
                }

            }
        });

        add(cookieAmount);
        cookieAmount.setBounds(440, 280, 90, 35);

        continueButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        continueButton.setForeground(new java.awt.Color(144, 0, 0));
        continueButton.setText("Continue");
        continueButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));

        //click button
        continueButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showDrinksPage();
            }
        });

        add(continueButton);
        continueButton.setBounds(140, 510, 180, 60);


        backButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        backButton.setForeground(new java.awt.Color(144, 0, 0));
        backButton.setText("Go Back");
        backButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));

        //click button
        backButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showToppingsPage();
            }
        });

        add(backButton);
        backButton.setBounds(380, 510, 170, 60);

        sidesBackground.setIcon(new javax.swing.ImageIcon("momPop_Background7.png"));
        add(sidesBackground);
        sidesBackground.setBounds(0, 0, 710, 600);


    }

}

