import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import java.text.DecimalFormat;
import java.util.List;

public class cartPage extends JPanel {

    Variables variableObj = new Variables();


    public cartPage (MainFrame mainFrame) {


        this.variableObj = mainFrame.variableObj;

        JButton checkoutButton = new JButton();
        JButton mainMenuButton = new JButton();
        JButton pizzaBuilderButton = new JButton();
        JButton drinksButton = new JButton();
        JButton sidesButton = new JButton();


        setLayout(null);



        //JLabels
        JLabel cartBackground = new JLabel();


        JLabel pizzaText = new JLabel();
        JLabel toppingText = new JLabel();
        JLabel sideText = new JLabel();
        JLabel  drinkText = new JLabel();

        JLabel  pizzaPriceText = new JLabel();
        JLabel  toppingPriceText = new JLabel();
        JLabel sidePriceText = new JLabel();
        JLabel drinkPriceText = new JLabel();

        JLabel subTotalText = new JLabel();
        JLabel subTotal = new JLabel();
        JLabel tax = new JLabel();
        JLabel total = new JLabel();



        //when the page becomes visible
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                DecimalFormat df = new DecimalFormat("0.00");


                String pizzaSize = variableObj.getSizePizza();
                String crustType = variableObj.getCrustType();

                String pizzaResult="";

                if (pizzaSize.length()==0 && crustType.length()==0) {
                    //if user didnt pick size or crust
                    pizzaResult ="No Pizza";
                }
                else if (pizzaSize.length()==0 && crustType.length()>0) {
                    //defaults to medium if user didnt pick size
                    pizzaSize = "Medium";
                    pizzaResult ="Medium " + variableObj.getCrustType() + " Crust Pizza";
                }
                else if (pizzaSize.length()>0 && crustType.length()==0) {
                    //defaults to regular if user didnt pick crust
                    crustType = "Regular";
                    pizzaResult = variableObj.getSizePizza() + " Regular Crust Pizza";
                }
                else {
                    pizzaResult = variableObj.getSizePizza() + " " + variableObj.getCrustType() + " Crust Pizza";
                }


                double sizePrice=0.00;

                if (pizzaSize.equals("Small")) {
                    sizePrice=4.00;
                }
                else if (pizzaSize.equals("Medium")) {
                    sizePrice=6.00;
                }
                else if (pizzaSize.equals("Large")) {
                    sizePrice=8.00;

                }
                else if (pizzaSize.equals("XLarge")){
                    sizePrice=10.00;
                }



                pizzaText.setText(pizzaResult);
                pizzaPriceText.setText("$" + df.format(sizePrice));





                List toppings = variableObj.getToppings();
                int toppingsListSize = toppings.size();
                double toppingsPrice = 0.00;

                if (toppingsListSize>1) {
                    //if they choose toppings but no pizza, just give them default regular crust medium pizza
                    if (pizzaResult.equals("No Pizza")) {
                        pizzaResult="Medium Regular Crust Pizza";
                        sizePrice=6.00;

                        pizzaText.setText(pizzaResult);
                        pizzaPriceText.setText("$" + df.format(sizePrice));

                    }


                    toppingsListSize= toppingsListSize-1;

                    if (pizzaSize.equals("Small")) {
                        toppingsPrice = toppingsListSize * .50;
                    }
                    else if (pizzaSize.equals("Medium")) {
                        toppingsPrice = toppingsListSize * .75;
                    }
                    else if (pizzaSize.equals("Large")) {
                        toppingsPrice = toppingsListSize * 1.00;
                    }
                    else if (pizzaSize.equals("XLarge")){
                        toppingsPrice = toppingsListSize * 1.25;
                    }

                }


                String toppingsResult = "";

                for (int i=0; i<toppings.size(); i++) {
                    toppingsResult+= toppings.get(i) + ", ";
                }

                if (toppingsResult.length()>2) {
                    toppingsResult = toppingsResult.substring(0, toppingsResult.length() - 2);
                }
                else {
                    toppingsResult="None";
                }


                toppingText.setText("Topping(s):  "  + toppingsResult );
                toppingPriceText.setText("$" + df.format(toppingsPrice));




                int breadstickBites = variableObj.getBreadstickBitesAmount();
                int breadsticks = variableObj.getBreadSticksAmount();
                int cookies = variableObj.getChipCookieAmount();

                double sidesPrice=0.00;

                String sidesResult = "";

                if (breadstickBites>0) {
                    sidesPrice+= breadstickBites * 2.00;
                    sidesResult+= breadstickBites + " Breadstick Bites ";
                }
                if (breadsticks>0) {
                    sidesPrice+= breadsticks * 4.00;
                    sidesResult+= breadsticks + " Breadsticks ";
                }

                if (cookies>0) {
                    sidesPrice+= cookies * 4.00;
                    sidesResult+= cookies + " Chocolate Chip Cookies ";
                }

                if (breadstickBites==0 && cookies==0 && breadsticks==0) {
                    sidesResult= "No Sides";
                }


                sideText.setText(sidesResult);
                sidePriceText.setText("$" + df.format(sidesPrice));




                int sierraMist = variableObj.getSierraMistAmount();
                int rootBeer = variableObj.getRootBeerAmount();
                int water = variableObj.getWaterAmount();
                int lemonade = variableObj.getLemonadeAmount();
                int orangeSoda = variableObj.getOrangeSodaAmount();
                int pepsi = variableObj.getPepsiAmount();

                double drinksPrice = 0.00;

                String drinkResult="";

                if (sierraMist>0) {
                    drinksPrice = sierraMist * 1.00;
                    drinkResult+= sierraMist + " " + variableObj.getSierraMistOptions() + " Sierra Mist(s) ";
                }
                if (rootBeer>0) {
                    drinksPrice = rootBeer * 1.00;
                    drinkResult+= rootBeer + " " + variableObj.getRootBeerOptions() + " Root Beer(s) ";
                }

                if (water>0) {
                    drinksPrice = water * 1.00;
                    drinkResult+= water +" " + variableObj.getWaterOptions() + " Water(s) ";
                }

                if (lemonade>0) {
                    drinksPrice = lemonade * 1.00;
                    drinkResult+= lemonade + " " + variableObj.getLemonadeOptions() +" Lemonade(s) ";
                }
                if (orangeSoda>0) {
                    drinksPrice = orangeSoda * 1.00;
                    drinkResult+= orangeSoda +" " + variableObj.getOrangeSodaOptions() + " Orange Soda(s) ";
                }
                if (pepsi>0) {
                    drinksPrice = pepsi * 1.00;
                    drinkResult+= pepsi + " " + variableObj.getPepsiOptions() + " Pepsi(s) ";
                }

                if (water==0 && lemonade==0 && orangeSoda==0 && pepsi==0 && rootBeer==0 && sierraMist==0) {
                    drinkResult= "No Drinks";
                }

                drinkText.setText(drinkResult);
                drinkPriceText.setText("$" + df.format(drinksPrice));


                double subtotal = sizePrice + toppingsPrice + sidesPrice + drinksPrice;

                subTotalText.setText("$" + df.format(subtotal));
                subTotal.setText("Subtotal: $" + df.format(subtotal));


                double taxAmount = subtotal * .06; //.06 is the sales tax
                tax.setText("Tax: $" + df.format(taxAmount));

                double totalAmount = subtotal + taxAmount;
                total.setText( "Total: $" +df.format(totalAmount));

                variableObj.setTotal(totalAmount);
                variableObj.setOrder(pizzaResult, "Toppings: " + toppingsResult, sidesResult, drinkResult, "$" + df.format(subtotal), "$" +df.format(taxAmount), "$" +df.format(totalAmount));
            }
        });


        checkoutButton.setBackground(new java.awt.Color(144, 0, 0));
        checkoutButton.setFont(new java.awt.Font("Segoe UI", 1, 16));
        checkoutButton.setForeground(new java.awt.Color(255, 255, 255));
        checkoutButton.setText("Continue to Checkout");

        //click button
        checkoutButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showPaymentPage();
            }
        });


        add(checkoutButton);
        checkoutButton.setBounds(470, 270, 220, 50);

        mainMenuButton.setFont(new java.awt.Font("Segoe UI", 1, 16));
        mainMenuButton.setForeground(new java.awt.Color(144, 0, 0));
        mainMenuButton.setText("Go to Main Menu");

        //click button
        mainMenuButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showMainPage();
            }
        });

        add(mainMenuButton);
        mainMenuButton.setBounds(470, 330, 220, 50);

        pizzaBuilderButton.setBackground(new java.awt.Color(255, 255, 204));
        pizzaBuilderButton.setFont(new java.awt.Font("Segoe UI", 1, 16));
        pizzaBuilderButton.setForeground(new java.awt.Color(144, 0, 0));
        pizzaBuilderButton.setText("Go to Pizza Builder");

        //click button
        pizzaBuilderButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showPizzaBuilderPage();
            }
        });

        add(pizzaBuilderButton);
        pizzaBuilderButton.setBounds(470, 390, 220, 50);

        drinksButton.setBackground(new java.awt.Color(255, 255, 204));
        drinksButton.setFont(new java.awt.Font("Segoe UI", 1, 16));
        drinksButton.setForeground(new java.awt.Color(144, 0, 0));
        drinksButton.setText("Go to Drinks");

        //click button
        drinksButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showDrinksPage();
            }
        });

        add(drinksButton);
        drinksButton.setBounds(470, 460, 220, 50);

        sidesButton.setBackground(new java.awt.Color(255, 255, 204));
        sidesButton.setFont(new java.awt.Font("Segoe UI", 1, 16));
        sidesButton.setForeground(new java.awt.Color(144, 0, 0));
        sidesButton.setText("Go to Sides");

        //click button
        sidesButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showSidesPage();

            }
        });

        add(sidesButton);
        sidesButton.setBounds(470, 520, 220, 50);



        pizzaText.setBackground(new java.awt.Color(0, 0, 0));
        pizzaText.setFont(new java.awt.Font("SansSerif", 0, 15));
        pizzaText.setForeground(new java.awt.Color(144, 0, 0));

        add(pizzaText);
        pizzaText.setBounds(40, 170, 270, 30);


        toppingText.setFont(new java.awt.Font("SansSerif", 0, 15));
        toppingText.setForeground(new java.awt.Color(144, 0, 0));
        add(toppingText);
        toppingText.setBounds(40, 210, 280, 40);


        sideText.setFont(new java.awt.Font("SansSerif", 0, 15));
        sideText.setForeground(new java.awt.Color(144, 0, 0));
        add(sideText);
        sideText.setBounds(40, 250, 280, 40);

        drinkText.setFont(new java.awt.Font("SansSerif", 0, 15));
        drinkText.setForeground(new java.awt.Color(144, 0, 0));
        add(drinkText);
        drinkText.setBounds(40, 300, 260, 40);



        pizzaPriceText.setFont(new java.awt.Font("SansSerif", 2, 15));
        pizzaPriceText.setForeground(new java.awt.Color(144, 0, 0));
        add(pizzaPriceText);
        pizzaPriceText.setBounds(350, 170, 90, 24);

        toppingPriceText.setFont(new java.awt.Font("SansSerif", 2, 15));
        toppingPriceText.setForeground(new java.awt.Color(144, 0, 0));
        add(toppingPriceText);
        toppingPriceText.setBounds(350, 210, 90, 24);

        sidePriceText.setFont(new java.awt.Font("SansSerif", 2, 15));
        sidePriceText.setForeground(new java.awt.Color(144, 0, 0));


        add(sidePriceText);
        sidePriceText.setBounds(350, 260, 90, 24);

        drinkPriceText.setFont(new java.awt.Font("SansSerif", 2, 15));
        drinkPriceText.setForeground(new java.awt.Color(144, 0, 0));
        add(drinkPriceText);
        drinkPriceText.setBounds(350, 310, 45, 24);



        subTotalText.setFont(new java.awt.Font("SansSerif", 3, 18));
        subTotalText.setForeground(new java.awt.Color(144, 0, 0));

        subTotalText.setText("");

        add(subTotalText);
        subTotalText.setBounds(350, 460, 120, 24);

        subTotal.setFont(new java.awt.Font("Segoe UI", 2, 16));
        subTotal.setText("");
        add(subTotal);
        subTotal.setBounds(500, 140, 120, 25);

        tax.setFont(new java.awt.Font("Segoe UI", 2, 16));
        tax.setText("");
        add(tax);
        tax.setBounds(500, 180, 120, 22);

        total.setFont(new java.awt.Font("Segoe UI", 1, 16));
        total.setText("");
        add(total);
        total.setBounds(500, 220, 120, 22);



        cartBackground.setIcon(new javax.swing.ImageIcon("momPop_Background9.png"));
        add(cartBackground);
        cartBackground.setBounds(0, -10, 770, 610);

    }


}
