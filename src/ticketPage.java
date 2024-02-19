import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DecimalFormat;
import java.util.List;

public class ticketPage extends JPanel {
    Variables variableObj = new Variables();
    JLabel ticketResult = new JLabel();

    public ticketPage (MainFrame mainFrame) {
        this.variableObj = mainFrame.variableObj;


        JLabel orderTextLabel = new JLabel();
        JLabel thankYouTextLabel = new JLabel();
        JButton mainPageButton11 = new JButton();
        JButton orderPageButton11 = new JButton();
        JLabel ticketBackground = new JLabel();


        setLayout(null);


        //when the page becomes visible
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                String order = variableObj.getOrderWithTip();
                String output="<html>";

                String[] lines = order.split("\n");

                for (String line : lines) {
                    output+= line + "<br/>";
                }

                output = output + "</html>";

                ticketResult.setText(output);
            }
        });





        orderTextLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 24));
        orderTextLabel.setText("Your Order Is:");
        add(orderTextLabel);
        orderTextLabel.setBounds(190, 160, 240, 25);




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


        thankYouTextLabel.setFont(new java.awt.Font("Gill Sans MT", 3, 30));
        thankYouTextLabel.setForeground(new java.awt.Color(144, 0, 0));
        thankYouTextLabel.setText("THANK YOU!");
        add(thankYouTextLabel);
        thankYouTextLabel.setBounds(260, 500, 250, 35);

        mainPageButton11.setFont(new java.awt.Font("Segoe UI", 1, 14));
        mainPageButton11.setForeground(new java.awt.Color(144, 0, 0));
        mainPageButton11.setText("Go to Main");

        //click button
        mainPageButton11.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showMainPage();
            }
        });


        add(mainPageButton11);
        mainPageButton11.setBounds(10, 540, 130, 30);

        orderPageButton11.setFont(new java.awt.Font("Segoe UI", 1, 14));
        orderPageButton11.setForeground(new java.awt.Color(144, 0, 0));
        orderPageButton11.setText("Order Again");

        //click button
        orderPageButton11.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mainFrame.showPizzaBuilderPage();
            }
        });


        add(orderPageButton11);
        orderPageButton11.setBounds(560, 540, 130, 30);



        ticketBackground.setIcon(new javax.swing.ImageIcon("momPop_Background11.png"));
        add(ticketBackground);
        ticketBackground.setBounds(0, -10, 790, 610);
    }
}
