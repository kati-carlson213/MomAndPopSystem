import javax.swing.*;


class MainFrame extends JFrame {


    protected Variables variableObj;

    protected Login login;

    private JPanel containerPanel;




    public MainFrame() {
        variableObj = new Variables();
        login = new Login();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mom and Pop's Pizzeria");
        setLayout(null);
        setResizable(false);


        containerPanel = new JPanel();
        containerPanel.setLayout(null);
        containerPanel.setBounds(0, 0, 710, 620);

        //pages
        MainPage mainPage = new MainPage(this);
        mainPage.setSize(710, 620);

        AboutUsPage aboutPage = new AboutUsPage(this);
        aboutPage.setSize(710, 620);
        aboutPage.setVisible(false);

        MenuPage menuPage = new MenuPage(this);
        menuPage.setSize(710, 620);
        menuPage.setVisible(false);

        pizzaBuilderPage pizzaPage = new pizzaBuilderPage(this);
        pizzaPage.setSize(710, 620);
        pizzaPage.setVisible(false);

        loginPage loginPage = new loginPage(this);
        loginPage.setSize(710, 620);
        loginPage.setVisible(false);

        createAccountPage newAccPage = new createAccountPage(this);
        newAccPage.setSize(710, 620);
        newAccPage.setVisible(false);

        pickSizePage sizePage = new pickSizePage(this);
        sizePage.setSize(710, 620);
        sizePage.setVisible(false);

        toppingsPage toppingsPage = new toppingsPage(this);
        toppingsPage.setSize(710, 620);
        toppingsPage.setVisible(false);

        sidesPage sidesPage = new sidesPage(this);
        sidesPage.setSize(710, 620);
        sidesPage.setVisible(false);

        drinksPage drinksPage = new drinksPage(this);
        drinksPage.setSize(710, 620);
        drinksPage.setVisible(false);

        cartPage cartPage = new cartPage(this);
        cartPage.setSize(710, 620);
        cartPage.setVisible(false);

        paymentPage paymentPage = new paymentPage(this);
        paymentPage.setSize(710, 620);
        paymentPage.setVisible(false);

        ticketPage ticketPage = new ticketPage(this);
        ticketPage.setSize(710, 620);
        ticketPage.setVisible(false);

        accountInfoPage accInfoPage = new accountInfoPage(this);
        accInfoPage.setSize(710, 620);
        accInfoPage.setVisible(false);

        orderInfoPage  orderInfoPage = new  orderInfoPage(this);
        orderInfoPage.setSize(710, 620);
        orderInfoPage.setVisible(false);




        //add pages to container
        containerPanel.add(mainPage);
        containerPanel.add(aboutPage);
        containerPanel.add(menuPage);
        containerPanel.add(pizzaPage);
        containerPanel.add(loginPage);
        containerPanel.add(newAccPage);
        containerPanel.add(sizePage);
        containerPanel.add(toppingsPage);
        containerPanel.add(sidesPage);
        containerPanel.add(drinksPage);
        containerPanel.add(cartPage);
        containerPanel.add(paymentPage);
        containerPanel.add(ticketPage);
        containerPanel.add(accInfoPage);
        containerPanel.add(orderInfoPage);


        add(containerPanel);

        pack();
        setLocationRelativeTo(null);


    }


    //helper methods to help redirect to page
    public void showMainPage() {
        containerPanel.getComponent(0).setVisible(true);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showAboutPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(true);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showMenuPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(true);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showPizzaBuilderPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(true);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showLoginPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(true);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showMakeAccPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(true);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showPickSizePage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(true);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showToppingsPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(true);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showSidesPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(true);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showDrinksPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(true);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showCartPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(true);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showPaymentPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(true);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showTicketPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(true);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(false);
    }

    public void showAccInfoPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(true);
        containerPanel.getComponent(14).setVisible(false);
    }


    public void showOrderInfoPage() {
        containerPanel.getComponent(0).setVisible(false);
        containerPanel.getComponent(1).setVisible(false);
        containerPanel.getComponent(2).setVisible(false);
        containerPanel.getComponent(3).setVisible(false);
        containerPanel.getComponent(4).setVisible(false);
        containerPanel.getComponent(5).setVisible(false);
        containerPanel.getComponent(6).setVisible(false);
        containerPanel.getComponent(7).setVisible(false);
        containerPanel.getComponent(8).setVisible(false);
        containerPanel.getComponent(9).setVisible(false);
        containerPanel.getComponent(10).setVisible(false);
        containerPanel.getComponent(11).setVisible(false);
        containerPanel.getComponent(12).setVisible(false);
        containerPanel.getComponent(13).setVisible(false);
        containerPanel.getComponent(14).setVisible(true);
    }

}



//main class/method
public class Webpage {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setSize(710, 620);

            // Change icon of window
            ImageIcon img = new ImageIcon("download.png");
            mainFrame.setIconImage(img.getImage());

            mainFrame.setVisible(true);
        });
    }
}