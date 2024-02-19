import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;


public class toppingsPage extends JPanel {
    Variables variableObj = new Variables();
    Login login = new Login();


    private List<String> toppingsList = new ArrayList<String>();

    public void changeTopping(String input) {
        if (toppingsList.contains(input)) {
            toppingsList.remove(input);
        }
        else {
            toppingsList.add(input);
        }
    }

    public List getToppings() {
        return toppingsList;
    }



    public toppingsPage (MainFrame mainFrame) {
        this.variableObj = mainFrame.variableObj;
        this.login = mainFrame.login;

        setLayout(null);

        JButton menuButton = new JButton();
        JButton orderButton = new JButton();
        JButton aboutButton = new JButton();
        JButton accountButton = new JButton();
        JButton continueButton = new JButton();
        JButton backButton= new JButton();
        JCheckBox cheeseCheck = new JCheckBox();
        JCheckBox pepperoniCheck = new JCheckBox();
        JCheckBox  sausageCheck = new JCheckBox();
        JCheckBox  hamCheck = new JCheckBox();
        JCheckBox greenPepperCheck = new JCheckBox();
        JCheckBox onionCheck = new JCheckBox();
        JCheckBox mushroomCheck = new JCheckBox();
        JCheckBox tomatoCheck = new JCheckBox();
        JCheckBox pineappleCheck = new JCheckBox();
        JLabel toppingsBackground = new JLabel();



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
        orderButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
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
        accountButton.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
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

        continueButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        continueButton.setForeground(new java.awt.Color(144, 0, 0));
        continueButton.setText("Continue");

        //click button
        continueButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                List toppings = getToppings();
                variableObj.setToppings(toppings);

                String crustType = variableObj.getCrustType();
                String sizePizza = variableObj.getSizePizza();

                if (crustType.length()==0 && sizePizza.length()==0 && toppings.size()>0) {
                    JOptionPane.showMessageDialog(mainFrame, "NOTE: You can't have toppings without a pizza. \nIf you pick toppings, but no crust type or size of pizza, then you will be given \na MEDIUM REGULAR CRUST PIZZA by default.", "Alert", JOptionPane.WARNING_MESSAGE);
                }

                mainFrame.showSidesPage();
               }
        });


        continueButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));

        add(continueButton);
        continueButton.setBounds(160, 490, 180, 60);

        backButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        backButton.setForeground(new java.awt.Color(144, 0, 0));
        backButton.setText("Go Back");

        //click button
        backButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showPickSizePage();
                }
        });

        backButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));

        add(backButton);
        backButton.setBounds(370, 490, 170, 60);



        //cheese check
        cheeseCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                changeTopping("Cheese");
            }
        });

        add(cheeseCheck);
        cheeseCheck.setBounds(100, 250, 29, 29);

        //pepperoni check
        pepperoniCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                changeTopping("Pepperoni");
            }
        });

        add(pepperoniCheck);
        pepperoniCheck.setBounds(250, 250, 29, 29);

        //sausage check
        sausageCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                changeTopping("Sausage");
            }
        });

        add(sausageCheck);
        sausageCheck.setBounds(410, 250, 29, 29);

        //ham check
        hamCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                changeTopping("Ham");
            }
        });

        add(hamCheck);
        hamCheck.setBounds(570, 250, 29, 29);

        //green pepper check
        greenPepperCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                changeTopping("Green Pepper");

            }
        });

        add(greenPepperCheck);
        greenPepperCheck.setBounds(80, 400, 29, 29);

        //onion check
        onionCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                changeTopping("Onion");
            }
        });

        add(onionCheck);
        onionCheck.setBounds(220, 410, 29, 29);


        //mushroom check
        mushroomCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                changeTopping("Mushroom");
            }
        });

        add(mushroomCheck);
        mushroomCheck.setBounds(340, 410, 29, 29);


        //tomato check
        tomatoCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                changeTopping("Tomato");

            }
        });

        add(tomatoCheck);
        tomatoCheck.setBounds(470, 410, 29, 29);


        //pineapple check
        pineappleCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                changeTopping("Pineapple");
            }
        });

        add(pineappleCheck);
        pineappleCheck.setBounds(600, 410, 29, 29);

        toppingsBackground.setIcon(new javax.swing.ImageIcon("momPop_Background6.png"));
        add(toppingsBackground);
        toppingsBackground.setBounds(0, -10, 780, 610);
    }
}
