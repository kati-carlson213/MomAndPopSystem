import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class pickSizePage extends JPanel {

    Variables variableObj = new Variables();


    public pickSizePage (MainFrame mainFrame) {

        this.variableObj = mainFrame.variableObj;


        setLayout(null);


        JButton menuButton = new JButton();
        JButton orderButton = new JButton();
        JButton aboutButton = new JButton();
        JButton accountButton = new JButton();
        JButton continueButton = new JButton();
        JButton backButton = new JButton();
        JCheckBox smallCheck = new JCheckBox();
        JCheckBox mediumCheck = new JCheckBox();
        JCheckBox  largeCheck = new JCheckBox();
        JCheckBox xLargeCheck = new JCheckBox();
        JLabel pizzaSizeBackground = new JLabel();

        ButtonGroup pizzaSizeBG = new ButtonGroup();
        pizzaSizeBG.add(smallCheck);
        pizzaSizeBG.add(mediumCheck);
        pizzaSizeBG.add(largeCheck);
        pizzaSizeBG.add(xLargeCheck);


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
                //--
            }
        });


        add(accountButton);
        accountButton.setBounds(550, 40, 108, 32);

        continueButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        continueButton.setForeground(new java.awt.Color(144, 0, 0));
        continueButton.setText("Continue");
        continueButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));

        //click button
        continueButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showToppingsPage();
                }
        });


        add(continueButton);
        continueButton.setBounds(150, 500, 180, 60);

        backButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        backButton.setForeground(new java.awt.Color(144, 0, 0));
        backButton.setText("Go Back");
        backButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));

        //click button
        backButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showPizzaBuilderPage();
                }
        });

        add(backButton);
        backButton.setBounds(350, 500, 170, 60);


        //small check
        smallCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                variableObj.setSizePizza("Small");
            }
        });

        add(smallCheck);
        smallCheck.setBounds(90, 420, 40, 29);


        //medium check
        mediumCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                variableObj.setSizePizza("Medium");

            }
        });

        add(mediumCheck);
        mediumCheck.setBounds(210, 420, 40, 29);

        //large check
        largeCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                variableObj.setSizePizza("Large");

            }
        });


        add(largeCheck);
        largeCheck.setBounds(370, 420, 40, 29);

        //xlarge check
        xLargeCheck.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                variableObj.setSizePizza("XLarge");

            }
        });

        add(xLargeCheck);
        xLargeCheck.setBounds(550, 420, 40, 29);



        pizzaSizeBackground.setIcon(new javax.swing.ImageIcon("momPop_Background5.png"));

        add(pizzaSizeBackground);
        pizzaSizeBackground.setBounds(0, 0, 700, 610);

    }
}
