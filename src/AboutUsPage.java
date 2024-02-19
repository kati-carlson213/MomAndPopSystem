import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUsPage extends JPanel {

    Login login = new Login();
    public AboutUsPage(MainFrame mainFrame) {
        setLayout(null);

        this.login = mainFrame.login;

        JButton mainPageButton = new JButton("Main Page");

        mainPageButton.setBackground(new java.awt.Color(144, 0, 0));
        mainPageButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        mainPageButton.setForeground(new java.awt.Color(255, 255, 255));
        mainPageButton.setFocusPainted(false);

        mainPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showMainPage();
            }
        });
        add(mainPageButton);
        mainPageButton.setBounds(40, 30, 120, 32);



        JButton orderPageButton = new JButton("Order Page");
        orderPageButton.setBackground(new java.awt.Color(144, 0, 0));
        orderPageButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        orderPageButton.setForeground(new java.awt.Color(255, 255, 255));
        orderPageButton.setFocusPainted(false);

        orderPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showOrderInfoPage();
            }
        });
        add(orderPageButton);
        orderPageButton.setBounds(190, 30, 160, 32);



        JButton menuPageButton = new JButton("Menu");
        menuPageButton.setBackground(new java.awt.Color(144, 0, 0));
        menuPageButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
        menuPageButton.setForeground(new java.awt.Color(255, 255, 255));
        menuPageButton.setFocusPainted(false);

        menuPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showMenuPage();
            }
        });
        add(menuPageButton);
        menuPageButton.setBounds(380, 30, 140, 32);



        JButton accountButton = new JButton("Account");
        accountButton.setBackground(new java.awt.Color(144, 0, 0));
        accountButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18));
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
        accountButton.setBounds(550, 30, 108, 32);


        JLabel aboutBackground = new JLabel(new ImageIcon("momPop_Background3.png"));
        add(aboutBackground);
        aboutBackground.setBounds(0, 0, 700, 600);
    }
}
