import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JPanel {
    Login login = new Login();

    public MainPage (MainFrame mainFrame) {
        setLayout(null);

        this.login = mainFrame.login;

        JButton menuPageButton = new JButton("Menu");
        menuPageButton.setBackground(new java.awt.Color(0, 0, 0));
        menuPageButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
        menuPageButton.setForeground(new java.awt.Color(255, 255, 255));
        menuPageButton.setFocusPainted(false);

        menuPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showMenuPage();
            }
        });
        add(menuPageButton);
        menuPageButton.setBounds(220, 170, 90, 30);



        JButton orderPageButton = new JButton("Order Info");
        orderPageButton.setBackground(new java.awt.Color(0, 0, 0));
        orderPageButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
        orderPageButton.setForeground(new java.awt.Color(255, 255, 255));
        orderPageButton.setFocusPainted(false);


        orderPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showOrderInfoPage();
            }
        });
        add(orderPageButton);
        orderPageButton.setBounds(320, 170, 108, 30);



        JButton aboutUsButton = new JButton("About Us");
        aboutUsButton.setBackground(new java.awt.Color(0, 0, 0));
        aboutUsButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
        aboutUsButton.setForeground(new java.awt.Color(255, 255, 255));
        aboutUsButton.setFocusPainted(false);


        aboutUsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showAboutPage();
            }
        });
        add(aboutUsButton);
        aboutUsButton.setBounds(440, 170, 108, 30);



        JButton accountButton = new JButton("Account");
        accountButton.setBackground(new java.awt.Color(0, 0, 0));
        accountButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
        accountButton.setForeground(new java.awt.Color(255, 255, 255));
        accountButton.setFocusPainted(false);

        accountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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



        JButton yourAccButton = new JButton("Make a New Account");
        yourAccButton.setBackground(new java.awt.Color(144, 0, 0));
        yourAccButton.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18));
        yourAccButton.setForeground(new java.awt.Color(255, 255, 255));
        yourAccButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        yourAccButton.setFocusPainted(false);

        yourAccButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (login.getLoginStatus()==true) {
                    login.wasLoginSuccessful(false);
                }
                mainFrame.showMakeAccPage();
            }
        });
        add(yourAccButton);
        yourAccButton.setBounds(190, 220, 250, 60);



        JButton pizzaBuilderButton = new JButton("Go to Pizza Builder");
        pizzaBuilderButton.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18));
        pizzaBuilderButton.setForeground(new java.awt.Color(144, 0, 0));
        pizzaBuilderButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        pizzaBuilderButton.setFocusPainted(false);

        pizzaBuilderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showPizzaBuilderPage();
            }
        });
        add(pizzaBuilderButton);
        pizzaBuilderButton.setBounds(450, 220, 220, 60);



        JButton seeMoreButton = new JButton("See More>>");
        seeMoreButton.setFont(new java.awt.Font("Gill Sans MT", 1, 18));
        seeMoreButton.setForeground(new java.awt.Color(144, 0, 0));
        seeMoreButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));
        seeMoreButton.setFocusPainted(false);

        seeMoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //redirect
            }
        });
        add(seeMoreButton);
        seeMoreButton.setBounds(200, 310, 120, 35);

        JLabel mainBackground = new JLabel(new ImageIcon("momPop_Background1.png"));
        add(mainBackground);
        mainBackground.setBounds(0, 0, 700, 610);
    }
}
