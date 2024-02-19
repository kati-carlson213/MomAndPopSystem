import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class orderInfoPage extends JPanel {
    Variables variableObj = new Variables();
    JLabel ticketResult;

    public orderInfoPage (MainFrame mainFrame) {
        this.variableObj = mainFrame.variableObj;

        //when the page becomes visible
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                String pizzaSize = variableObj.getSizePizza();
                String crustType = variableObj.getCrustType();

                String pizzaResult="";

                if (pizzaSize.length()==0 && crustType.length()==0) {
                    //if user didnt pick size or crust
                    pizzaResult ="No Pizza";
                }
                else if (pizzaSize.length()==0 && crustType.length()>0) {
                    //defaults to medium if user didnt pick size
                    variableObj.setSizePizza("Medium");
                    pizzaResult ="Medium " + variableObj.getCrustType() + " Crust Pizza";
                }
                else if (pizzaSize.length()>0 && crustType.length()==0) {
                    //defaults to regular if user didnt pick crust
                    variableObj.setCrustType("Regular");
                    pizzaResult = variableObj.getSizePizza() + " Regular Crust Pizza";
                }
                else {
                    pizzaResult = variableObj.getSizePizza() + " " + variableObj.getCrustType() + " Crust Pizza";
                }



                List toppings = variableObj.getToppings();
                int toppingsListSize = toppings.size();


                if (toppingsListSize>0) {
                    //if they choose toppings but no pizza, just give them default regular crust medium pizza
                    if (pizzaResult.equals("No Pizza")) {
                        pizzaResult="Medium Regular Crust Pizza";
                        variableObj.setCrustType("Regular");
                        variableObj.setSizePizza("Medium");
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




                int sierraMist = variableObj.getSierraMistAmount();
                int rootBeer = variableObj.getRootBeerAmount();
                int water = variableObj.getWaterAmount();
                int lemonade = variableObj.getLemonadeAmount();
                int orangeSoda = variableObj.getOrangeSodaAmount();
                int pepsi = variableObj.getPepsiAmount();


                String drinkResult="";

                if (sierraMist>0) {
                    drinkResult+= sierraMist + " " + variableObj.getSierraMistOptions() + " Sierra Mist(s) ";
                }
                if (rootBeer>0) {
                    drinkResult+= rootBeer + " " + variableObj.getRootBeerOptions() + " Root Beer(s) ";
                }

                if (water>0) {
                    drinkResult+= water +" " + variableObj.getWaterOptions() + " Water(s) ";
                }

                if (lemonade>0) {
                    drinkResult+= lemonade + " " + variableObj.getLemonadeOptions() +" Lemonade(s) ";
                }
                if (orangeSoda>0) {
                    drinkResult+= orangeSoda +" " + variableObj.getOrangeSodaOptions() + " Orange Soda(s) ";
                }
                if (pepsi>0) {
                    drinkResult+= pepsi + " " + variableObj.getPepsiOptions() + " Pepsi(s) ";
                }

                if (water==0 && lemonade==0 && orangeSoda==0 && pepsi==0 && rootBeer==0 && sierraMist==0) {
                    drinkResult= "No Drinks";
                }


                String order = pizzaResult + "\nToppings: " + toppingsResult + "\n" + sidesResult + "\n" + drinkResult;

                String output="<html>";

                String[] lines = order.split("\n");

                for (String line : lines) {
                    output+= line + "<br/>";
                }

                output = output + "</html>";

                ticketResult.setText(output);
            }
        });


        JLabel orderTextLabel = new JLabel();
        JButton mainPageButton= new JButton();
        JButton builderPageButton = new JButton();
        JLabel ticketBackground = new JLabel();


        setLayout(null);

        orderTextLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 24));
        orderTextLabel.setText("Your Order Is:");
        add(orderTextLabel);
        orderTextLabel.setBounds(190, 160, 240, 25);


        mainPageButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        mainPageButton.setForeground(new java.awt.Color(144, 0, 0));
        mainPageButton.setText("Go to Main");

        //click button
        mainPageButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showMainPage();
            }
        });


        add(mainPageButton);
        mainPageButton.setBounds(10, 540, 130, 30);

        builderPageButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        builderPageButton.setForeground(new java.awt.Color(144, 0, 0));
        builderPageButton.setText("Go to Pizza Builder");

        //click button
        builderPageButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showPizzaBuilderPage();
            }
        });


        add(builderPageButton);
        builderPageButton.setBounds(560, 540, 130, 30);



        ticketResult = new JLabel();
        ticketResult.setBounds(180, 200, 350, 280);
        ticketResult.setFont(new java.awt.Font("Segoe UI", 1, 20));
        ticketResult.setForeground(new java.awt.Color(154, 126, 126));


        ticketResult.setHorizontalAlignment(SwingConstants.CENTER);
        ticketResult.setVerticalAlignment(SwingConstants.TOP);
        ticketResult.setVerticalTextPosition(SwingConstants.TOP);
        ticketResult.setHorizontalTextPosition(SwingConstants.CENTER);
        ticketResult.setOpaque(true);

        add(ticketResult);

        ticketBackground.setIcon(new javax.swing.ImageIcon("momPop_Background15.png"));
        add(ticketBackground);
        ticketBackground.setBounds(0, -10, 790, 610);
    }

}
