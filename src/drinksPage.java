import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class drinksPage extends JPanel {
    Variables variableObj = new Variables();
    Login login = new Login();

    public drinksPage (MainFrame mainFrame) {
        this.variableObj = mainFrame.variableObj;
        this.login = mainFrame.login;

        JButton menuButton = new JButton();
        JButton orderButton = new JButton();
        JButton aboutButton = new JButton();
        JButton accountButton = new JButton();
        JButton continueButton = new JButton();
        JButton backButton = new JButton();

        JTextField pepsiAmount = new JTextField();
        JTextField orangeSodaAmount = new JTextField();
        JTextField  sierraMistAmount = new JTextField();
        JTextField  lemonadeAmount = new JTextField();
        JTextField  rootBeerAmount = new JTextField();
        JTextField  waterAmount = new JTextField();

        JComboBox pepsiOptions = new JComboBox<>();
        JComboBox orangeSodaOptions = new JComboBox<>();
        JComboBox  sierraMistOptions = new JComboBox<>();
        JComboBox lemonadeOptions = new JComboBox<>();
        JComboBox rootBeerOptions = new JComboBox<>();
        JComboBox waterOptions = new JComboBox<>();
        JLabel drinksBackground = new JLabel();

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

        continueButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        continueButton.setForeground(new java.awt.Color(144, 0, 0));
        continueButton.setText("Continue");
        continueButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));


        //click button
        continueButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showCartPage();
                }
        });

        add(continueButton);
        continueButton.setBounds(140, 530, 180, 60);

        backButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        backButton.setForeground(new java.awt.Color(144, 0, 0));
        backButton.setText("Go Back");
        backButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));

        //click button
        backButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showSidesPage();
            }
        });

        add(backButton);
        backButton.setBounds(370, 530, 170, 60);

        pepsiAmount.setFont(new java.awt.Font("Segoe UI", 0, 14));
        pepsiAmount.setText("");
        pepsiAmount.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updatePepsiAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePepsiAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePepsiAmount();
            }

            private void updatePepsiAmount() {
                String pepsiNum = pepsiAmount.getText();
                if (pepsiNum.matches("-?\\d+(\\.\\d+)?")) {
                    int pepsiAmount = Integer.parseInt(pepsiNum);
                    variableObj.setPepsiAmount(pepsiAmount);
                }
                else {
                    variableObj.setPepsiAmount(0);
                }
            }
        });

        add(pepsiAmount);
        pepsiAmount.setBounds(150, 220, 96, 30);

        orangeSodaAmount.setFont(new java.awt.Font("Segoe UI", 0, 14));
        orangeSodaAmount.setText("");
        orangeSodaAmount.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateOrangeSodaAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateOrangeSodaAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateOrangeSodaAmount();
            }

            private void updateOrangeSodaAmount() {
                String orangeSodaNum = orangeSodaAmount.getText();

                if (orangeSodaNum.matches("-?\\d+(\\.\\d+)?")) {
                int orangeAmount = Integer.parseInt(orangeSodaNum);
                variableObj.setOrangeSodaAmount(orangeAmount);}
                else {
                    variableObj.setOrangeSodaAmount(0);
                }
            }
        });

        add(orangeSodaAmount);
        orangeSodaAmount.setBounds(420, 220, 100, 30);

        sierraMistAmount.setFont(new java.awt.Font("Segoe UI", 0, 14));
        sierraMistAmount.setText("");
        sierraMistAmount.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateSierraMistAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSierraMistAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSierraMistAmount();
            }

            private void updateSierraMistAmount() {
                String sierraNum = sierraMistAmount.getText();

                if (sierraNum.matches("-?\\d+(\\.\\d+)?")) {
                    int sierraAmount = Integer.parseInt(sierraNum);
                    variableObj.setSierraMistAmount(sierraAmount);
                }
                else {
                    variableObj.setSierraMistAmount(0);
                }

            }

        });


        add(sierraMistAmount);
        sierraMistAmount.setBounds(150, 360, 100, 30);

        lemonadeAmount.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lemonadeAmount.setText("");
        lemonadeAmount.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateLemonadeAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLemonadeAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLemonadeAmount();
            }

            private void updateLemonadeAmount() {
                String lemonadeNum = lemonadeAmount.getText();
                if (lemonadeNum.matches("-?\\d+(\\.\\d+)?")) {
                    int lemonadeAmount = Integer.parseInt(lemonadeNum);
                    variableObj.setLemonadeAmount(lemonadeAmount);
                }
                else {
                    variableObj.setLemonadeAmount(0);
                }
            }
        });


        add(lemonadeAmount);
        lemonadeAmount.setBounds(420, 360, 100, 30);

        rootBeerAmount.setFont(new java.awt.Font("Segoe UI", 0, 14));
        rootBeerAmount.setText("");
        rootBeerAmount.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateRootBeerAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateRootBeerAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateRootBeerAmount();
            }

            private void updateRootBeerAmount() {
                String rootBeerNum = rootBeerAmount.getText();
                if (rootBeerNum.matches("-?\\d+(\\.\\d+)?")) {
                    int beerAmount = Integer.parseInt(rootBeerNum);
                    variableObj.setRootBeerAmount(beerAmount);
                }
                else {
                    variableObj.setRootBeerAmount(0);
                }

            }
        });


        add(rootBeerAmount);
        rootBeerAmount.setBounds(140, 460, 100, 30);

        waterAmount.setFont(new java.awt.Font("Segoe UI", 0, 14));
        waterAmount.setText("");
        waterAmount.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateWaterAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateWaterAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateWaterAmount();
            }

            private void updateWaterAmount() {
                String waterNum = waterAmount.getText();
                if (waterNum.matches("-?\\d+(\\.\\d+)?")) {
                    int waterAmount = Integer.parseInt(waterNum);
                    variableObj.setWaterAmount(waterAmount);
                }
                else {
                    variableObj.setWaterAmount(0);
                }

            }
        });

        add(waterAmount);
        waterAmount.setBounds(410, 470, 100, 30);

        pepsiOptions.setBackground(new java.awt.Color(255, 255, 204));
        pepsiOptions.setFont(new java.awt.Font("Segoe UI", 0, 14));
        pepsiOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diet Small", "Diet Medium", "Diet Large", "Regular Small", "Regular Medium", "Regular Large" }));

        pepsiOptions.addItemListener( new ItemListener() {
            private String previousSelection = null;
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String currentSelection = (String) pepsiOptions.getSelectedItem();

                    if (!currentSelection.equals(previousSelection)) {
                        variableObj.setPepsiOptions(currentSelection);
                        previousSelection = currentSelection;
                    }
                }
            }
        });


        add(pepsiOptions);
        pepsiOptions.setBounds(190, 170, 80, 40);

        orangeSodaOptions.setBackground(new java.awt.Color(255, 255, 204));
        orangeSodaOptions.setFont(new java.awt.Font("Segoe UI", 0, 14));
        orangeSodaOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Diet Small", "Diet Medium", "Diet Large", "Regular Small", "Regular Medium", "Regular Large" }));
        orangeSodaOptions.addItemListener(new ItemListener() {
            private String previousSelection = null;
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String currentSelection = (String) orangeSodaOptions.getSelectedItem();

                    if (!currentSelection.equals(previousSelection)) {
                        variableObj.setOrangeSodaOptions(currentSelection);
                        previousSelection = currentSelection;
                    }
                }
            }
        });

        add(orangeSodaOptions);
        orangeSodaOptions.setBounds(460, 170, 80, 40);

        sierraMistOptions.setBackground(new java.awt.Color(255, 255, 204));
        sierraMistOptions.setFont(new java.awt.Font("Segoe UI", 0, 14));
        sierraMistOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large"}));
        sierraMistOptions.addItemListener( new ItemListener() {
            private String previousSelection = null;
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String currentSelection = (String) sierraMistOptions.getSelectedItem();

                    if (!currentSelection.equals(previousSelection)) {
                        variableObj.setSierraMistOptions(currentSelection);
                        previousSelection = currentSelection;
                    }
                }
            }
        });

        add(sierraMistOptions);
        sierraMistOptions.setBounds(190, 300, 70, 40);

        lemonadeOptions.setBackground(new java.awt.Color(255, 255, 204));
        lemonadeOptions.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lemonadeOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));
        lemonadeOptions.addItemListener( new ItemListener() {
            private String previousSelection = null;
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String currentSelection = (String) lemonadeOptions.getSelectedItem();

                    if (!currentSelection.equals(previousSelection)) {
                        variableObj.setLemonadeOptions(currentSelection);
                        previousSelection = currentSelection;
                    }
                }
            }
        });

        add(lemonadeOptions);
        lemonadeOptions.setBounds(460, 310, 70, 40);

        rootBeerOptions.setBackground(new java.awt.Color(255, 255, 204));
        rootBeerOptions.setFont(new java.awt.Font("Segoe UI", 0, 14));
        rootBeerOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diet Small", "Diet Medium", "Diet Large", "Regular Small", "Regular Medium", "Regular Large" }));
        add(rootBeerOptions);
        rootBeerOptions.setBounds(180, 420, 75, 30);

        rootBeerOptions.addItemListener( new ItemListener() {
            private String previousSelection = null;
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String currentSelection = (String) rootBeerOptions.getSelectedItem();

                    if (!currentSelection.equals(previousSelection)) {
                        variableObj.setRootBeerOptions(currentSelection);
                        previousSelection = currentSelection;
                    }
                }
            }
        });

        waterOptions.setBackground(new java.awt.Color(255, 255, 204));
        waterOptions.setFont(new java.awt.Font("Segoe UI", 0, 14));
        waterOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large"}));
        waterOptions.addItemListener( new ItemListener() {
            private String previousSelection = null;
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String currentSelection = (String) waterOptions.getSelectedItem();

                    if (!currentSelection.equals(previousSelection)) {
                        variableObj.setWaterOptions(currentSelection);
                        previousSelection = currentSelection;
                    }
                }
            }
        });

        add(waterOptions);
        waterOptions.setBounds(450, 430, 70, 30);

        drinksBackground.setIcon(new javax.swing.ImageIcon("momPop_Background8.png"));

        add(drinksBackground);
        drinksBackground.setBounds(0, 0, 700, 600);
    }
}


