import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class paymentPage extends JPanel {

    Variables variableObj = new Variables();


    //credit card info
    private String cardNumber="";
    private String expirationDate="";
    private String code ="";


    private String orderWithTip = "";



    //variables to track button clicks of tips
    private int clickCountTen=0;
    private int clickCountTwenty=0;
    private int clickCountThirty=0;

    private double price = 0.00;





    //uses Luhn algorithm to validate
    public static boolean isCreditValid(String cardNumber) {
        int sum = 0;
        boolean alternate = false;

        for (int i = (cardNumber.length() - 1); i >= 0; i--) {
            int num = Integer.parseInt(cardNumber.substring(i, i + 1));

            if (alternate) {
                num *= 2;
                if (num > 9) {
                    num = (num % 10) + 1;
                }
            }

            sum += num;
            alternate = !alternate;
        }

        boolean validation = (sum % 10 == 0);
        return validation;
    }


    public static boolean isCardExpired(String userInput) {
        // Get current date
        LocalDate currentDate = LocalDate.now();

        //pad -- if user inputted like 2/22, pad to 02/22
        if (userInput.length()==4 && userInput.charAt(1)== '/') {
            userInput= '0' + userInput;
        }

        // Assuming the input format is mm/yy
        String expDate = "20" + userInput.substring(3,5) + "-" + userInput.substring(0,2) + "-01";

        LocalDate expiryDate = LocalDate.parse(expDate);

        boolean expirationStatus = expiryDate.isBefore(currentDate);

        return expirationStatus;
    }



    //checks if string is numeric only. for credit card info
    public static boolean containsNotNumbers(String input) {
        boolean result =  !input.matches("[0-9\\s]+");
        return result;
    }


    //same as above, but checks if numeric AND allows "." for custom tip input
    public static boolean isNumeric(String input) {
        boolean result = input.matches("^\\d*\\.?\\d*$");
        return result;
    }



    public paymentPage (MainFrame mainFrame) {


        this.variableObj = mainFrame.variableObj;

        JButton tenTip = new JButton();
        JButton twentyTip = new JButton();
        JButton thirtyTip = new JButton();
        JButton backButton10 = new JButton();
        JButton placeOrderButton = new JButton();
        JTextField cardNum = new JTextField();
        JTextField expDate = new JTextField();
        JTextField securityCode = new JTextField();
        JTextField customTip = new JTextField();
        JLabel paymentBackground = new JLabel();

        setLayout(null);


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {

                DecimalFormat df = new DecimalFormat("0.00");
                variableObj.setOrderWithTip("$0.00", df.format(variableObj.getTotal()));


                tenTip.setBackground(new java.awt.Color(255, 255, 204));
                tenTip.setFont(new java.awt.Font("Segoe UI", 0, 14));
                tenTip.setForeground(new java.awt.Color(144, 0, 0));
                tenTip.setText("10%");

                //click for 10% tip
                tenTip.addActionListener( new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        DecimalFormat df = new DecimalFormat("0.00");
                        clickCountTen++;

                        if (clickCountTen % 2 == 1 ) {
                            tenTip.setFont(new java.awt.Font("Segoe UI", 1, 14));
                            twentyTip.setFont(new java.awt.Font("Segoe UI", 0, 14));
                            thirtyTip.setFont(new java.awt.Font("Segoe UI", 0, 14));


                            String tipAmount="";

                            double totalAmount = variableObj.getTotal();
                            double tip = totalAmount * .10;
                            totalAmount = tip + totalAmount;

                            price = totalAmount;
                            variableObj.setOrderWithTip("10% of $" + df.format(variableObj.getTotal()) + " = $" + df.format(tip), df.format(totalAmount));

                        }
                        else {
                            tenTip.setFont(new java.awt.Font("Segoe UI", 0, 14));

                            double total = variableObj.getTotal();


                            price = total;
                            variableObj.setOrderWithTip("$0.00", df.format(total));
                        }
                    }
                });

                add(tenTip);
                tenTip.setBounds(160, 390, 80, 30);

                twentyTip.setBackground(new java.awt.Color(255, 255, 204));
                twentyTip.setFont(new java.awt.Font("Segoe UI", 0, 14));
                twentyTip.setForeground(new java.awt.Color(144, 0, 0));
                twentyTip.setText("20%");

                //click for 20% tip
                twentyTip.addActionListener( new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        DecimalFormat df = new DecimalFormat("0.00");
                        clickCountTwenty++;

                        if (clickCountTwenty % 2 == 1) {
                            tenTip.setFont(new java.awt.Font("Segoe UI", 0, 14));
                            twentyTip.setFont(new java.awt.Font("Segoe UI", 1, 14));
                            thirtyTip.setFont(new java.awt.Font("Segoe UI", 0, 14));

                            String tipAmount="";

                            double totalAmount =  variableObj.getTotal();
                            double tip = totalAmount * .20;
                            totalAmount = tip + totalAmount;

                            price = totalAmount;

                            variableObj.setOrderWithTip("20% of $"  + df.format(totalAmount) + " = $" + df.format(tip), df.format(totalAmount));

                        }
                        else  {
                            twentyTip.setFont(new java.awt.Font("Segoe UI", 0, 14));

                            double total = variableObj.getTotal();

                            price = total;

                            variableObj.setOrderWithTip("$0.00", Double.toString(total));

                        }
                    }
                });

                add(twentyTip);
                twentyTip.setBounds(250, 390, 80, 30);

                thirtyTip.setBackground(new java.awt.Color(255, 255, 204));
                thirtyTip.setFont(new java.awt.Font("Segoe UI", 0, 14));
                thirtyTip.setForeground(new java.awt.Color(144, 0, 0));
                thirtyTip.setText("30%");




                //click for 30% tip
                thirtyTip.addActionListener( new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        DecimalFormat df = new DecimalFormat("0.00");

                        clickCountThirty++;

                        if (clickCountThirty % 2 == 1) {
                            tenTip.setFont(new java.awt.Font("Segoe UI", 0, 14));
                            twentyTip.setFont(new java.awt.Font("Segoe UI", 0, 14));
                            thirtyTip.setFont(new java.awt.Font("Segoe UI", 1, 14));

                            String tipAmount="";

                            double totalAmount = variableObj.getTotal();
                            double tip = totalAmount * .30;
                            totalAmount = tip + totalAmount;

                            price = totalAmount;

                            variableObj.setOrderWithTip("30% of $" + df.format(variableObj.getTotal()) + " = $" + df.format(tip), df.format(totalAmount));

                        }
                        else {
                            thirtyTip.setFont(new java.awt.Font("Segoe UI", 0, 14));

                            double  total = variableObj.getTotal();

                            price = total;

                            variableObj.setOrderWithTip("$0.00", df.format(total));
                        }

                    }
                });

                add(thirtyTip);
                thirtyTip.setBounds(340, 390, 80, 30);


                customTip.setBackground(new java.awt.Color(255, 255, 204));
                customTip.setFont(new java.awt.Font("Segoe UI", 2, 14));
                customTip.setForeground(new java.awt.Color(144, 0, 0));
                customTip.setText("Custom Tip: ");


                customTip.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        updateCustomTip();
                    }
                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        updateCustomTip();
                    }
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        updateCustomTip();
                    }

                    private void updateCustomTip() {
                        String inputTip="";
                        inputTip = customTip.getText();
                        DecimalFormat df = new DecimalFormat("0.00");

                        if (inputTip.length() != 0) {
                            if (inputTip.charAt(0) != '.' && isNumeric(inputTip)==true) {
                                double tip = Double.parseDouble(inputTip);
                                double totalAmount= variableObj.getTotal();

                                totalAmount = totalAmount + tip;

                                price = totalAmount;

                                variableObj.setOrderWithTip("$"+ df.format(tip), df.format(totalAmount));
                            }
                            else if (inputTip.charAt(0) == '.' && isNumeric(inputTip)==true) {
                                inputTip= '0' + inputTip;
                                double tip = Double.parseDouble(inputTip);
                                double totalAmount= variableObj.getTotal();

                                totalAmount = totalAmount + tip;

                                price = totalAmount;

                                variableObj.setOrderWithTip("$"+ df.format(tip), df.format(totalAmount));

                            }
                            else {
                                price = variableObj.getTotal();

                                variableObj.setOrderWithTip("$0.00" , df.format(variableObj.getTotal()));

                            }
                        }
                        else {
                            price = variableObj.getTotal();

                            variableObj.setOrderWithTip("$0.00" , df.format(variableObj.getTotal()));
                        }

                    }
                });
                add(customTip);
                customTip.setBounds(430, 390, 100, 30);




                cardNum.setFont(new java.awt.Font("Segoe UI", 0, 16));
                cardNum.setForeground(new java.awt.Color(102, 102, 102));
                cardNum.setText("xxxx xxxx xxxx xxxx");


                cardNum.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        updateCardNum();
                    }
                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        updateCardNum();
                    }
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        updateCardNum();
                    }

                    private void updateCardNum() {
                        cardNumber = cardNum.getText();

                    }
                });




                add(cardNum);
                cardNum.setBounds(310, 200, 160, 35);




                expDate.setFont(new java.awt.Font("Segoe UI", 0, 16));
                expDate.setForeground(new java.awt.Color(102, 102, 102));
                expDate.setText("mm/yy");

                expDate.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        updateExpDate();
                    }
                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        updateExpDate();
                    }
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        updateExpDate();
                    }

                    private void updateExpDate() {
                        expirationDate = expDate.getText();
                    }
                });

                add(expDate);
                expDate.setBounds(320, 250, 96, 32);


                securityCode.setFont(new java.awt.Font("Segoe UI", 0, 16));
                securityCode.setForeground(new java.awt.Color(102, 102, 102));
                securityCode.setText("***");

                securityCode.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        updateSecurityCode();
                    }
                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        updateSecurityCode();
                    }
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        updateSecurityCode();
                    }

                    private void updateSecurityCode() {
                        code = securityCode.getText();
                    }
                });


                add(securityCode);
                securityCode.setBounds(320, 290, 96, 32);



                backButton10.setFont(new java.awt.Font("Rockwell", 1, 24));
                backButton10.setForeground(new java.awt.Color(144, 0, 0));
                backButton10.setText("Go Back");
                backButton10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 0, 0), 2));

                //click button
                backButton10.addActionListener( new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        mainFrame.showCartPage();
                    }
                });

                add(backButton10);
                backButton10.setBounds(100, 500, 220, 60);


                placeOrderButton.setBackground(new java.awt.Color(200, 131, 131));
                placeOrderButton.setFont(new java.awt.Font("Rockwell", 1, 24));
                placeOrderButton.setForeground(new java.awt.Color(255, 255, 255));
                placeOrderButton.setText("PLACE ORDER");
                placeOrderButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

                //click button
                placeOrderButton.addActionListener( new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {



                        boolean  creditCardValid=false;
                        boolean creditCardExpired=false;

                        cardNumber = cardNumber.replace(" ", "");

                        if (cardNumber.length()!=16 || containsNotNumbers(cardNumber)) {
                            JOptionPane.showMessageDialog(mainFrame, "Please input 16-digit number for your credit card!", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                        else {
                            //validates credit card num
                            creditCardValid = isCreditValid(cardNumber);

                            if (creditCardValid==false) {
                                JOptionPane.showMessageDialog(mainFrame, "Your credit card number is invalid!", "Alert", JOptionPane.WARNING_MESSAGE);
                            }

                            else {

                                //once credit card num is validated, then it checks expiration date
                                if (expirationDate.length()>4 && expirationDate.length()<6)  {
                                    if (expirationDate.indexOf('/') == -1) {
                                        JOptionPane.showMessageDialog(mainFrame, "Please input expiration date in correct format.", "Alert", JOptionPane.WARNING_MESSAGE);
                                    }
                                    else if (expirationDate.charAt(1) != '/' && expirationDate.charAt(2) != '/') {
                                        System.out.println(expirationDate.charAt(1)+ " " + expirationDate.charAt(2));

                                        JOptionPane.showMessageDialog(mainFrame, "Please input expiration date in correct format.", "Alert", JOptionPane.WARNING_MESSAGE);
                                    }
                                    else {
                                        creditCardExpired = isCardExpired(expirationDate);

                                        if (creditCardExpired==true) {
                                            JOptionPane.showMessageDialog(mainFrame, "Your credit card is expired!", "Alert", JOptionPane.WARNING_MESSAGE);
                                        }
                                        else {
                                            //credit card and expiration date are correct
                                            // this GUI/prototype doesnt interact w/ the user's bank, so cannot validate security code at the moment
                                            // just assume the security code is valid for now


                                            orderWithTip = variableObj.getOrderWithTip();


                                            String[] lines = orderWithTip.split("\n");

                                            String orderTicket ="";

                                            for (int i = 0; i < lines.length; i++) {
                                                orderTicket+= lines[i] + "    ";
                                            }




                                            //send payment info and order to database here
                                            InsertOrderIntoDatabase sendOrder = new InsertOrderIntoDatabase(mainFrame, orderTicket, cardNumber);

                                            //redirect to ticket page
                                            mainFrame.showTicketPage();
                                        }
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(mainFrame, "Please input expiration date in correct format.", "Alert", JOptionPane.WARNING_MESSAGE);
                                }
                            }

                        }

                    }
                });

                add(placeOrderButton);
                placeOrderButton.setBounds(370, 500, 250, 60);


                paymentBackground.setIcon(new javax.swing.ImageIcon("momPop_Background10.png"));
                add(paymentBackground);
                paymentBackground.setBounds(0, -60, 830, 720);

            }
        });


    }

}


