import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Login {
    private static boolean loginStatus=false;

    private String id = " ";



    public static void wasLoginSuccessful(boolean status) {
        loginStatus = status;
    }

    public boolean getLoginStatus() {
        return loginStatus;
    }



    public void setID(String input) {
        id = input;
    }

    public String getID () {
        return id;
    }

}



public class loginPage extends JPanel {

    Login login = new Login();
    public loginPage(MainFrame mainFrame) {
        setLayout(null);

        this.login = mainFrame.login;

        JTextField usernameInput = new JTextField();
        JPasswordField passwordInput = new JPasswordField();
        JButton submitButton = new JButton();
        JButton  createAccButton = new JButton();
        JButton mainPageButton = new JButton();
        JLabel loginBackground = new JLabel();



        usernameInput.setBackground(new java.awt.Color(231, 231, 231));
        usernameInput.setFont(new java.awt.Font("Segoe UI", 2, 18));
        usernameInput.setForeground(new java.awt.Color(102, 102, 102));
        usernameInput.setText("Username");
        add(usernameInput);
        usernameInput.setBounds(210, 100, 270, 35);



        passwordInput.setBackground(new java.awt.Color(229, 229, 229));
        passwordInput.setFont(new java.awt.Font("Segoe UI", 2, 18));
        passwordInput.setForeground(new java.awt.Color(102, 102, 102));
        passwordInput.setText("Password");

        add(passwordInput);
        passwordInput.setBounds(210, 150, 270, 35);


        submitButton.setText("Submit");

        //click button
        submitButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = usernameInput.getText();
                String password = String.valueOf(passwordInput.getPassword());

                GetLoginInfoFromDatabase database = new GetLoginInfoFromDatabase(mainFrame, username, password, login);

                boolean loggedIn = login.getLoginStatus();

                if (loggedIn==true) {
                    mainFrame.showAccInfoPage();
                }
                else {
                    JOptionPane.showMessageDialog(mainFrame, "Error -- incorrect login. Try again.", "Alert", JOptionPane.WARNING_MESSAGE);
                }

            }
        });




        add(submitButton);
        submitButton.setBounds(290, 200, 108, 35);

        createAccButton.setBackground(new java.awt.Color(102, 102, 102));
        createAccButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        createAccButton.setForeground(new java.awt.Color(255, 255, 255));
        createAccButton.setText("Create an Account");

        //click button
        createAccButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showMakeAccPage();
            }
        });

        add(createAccButton);
        createAccButton.setBounds(30, 520, 210, 35);

        mainPageButton.setBackground(new java.awt.Color(144, 0, 0));
        mainPageButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
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
        mainPageButton.setBounds(510, 520, 160, 35);

        loginBackground.setIcon(new javax.swing.ImageIcon("momPop_Background12.png"));
        add(loginBackground);
        loginBackground.setBounds(0, 0, 850, 600);

    }
}
