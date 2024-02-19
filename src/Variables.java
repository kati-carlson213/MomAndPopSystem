import java.util.ArrayList;
import java.util.List;

public class Variables {

    private String order = "";
    private String orderWithTip = "";
    private double total = 0.00;


    //pizza options
    private String crustType = "";
    private String sizePizza = "";
    private List<String> toppingsList = new ArrayList<String>();


    //sides options
    private  int breadstickBitesAmount;
    private  int breadSticksAmount;
    private  int chipCookieAmount;



    //drinks options. options meaning size + whether its diet or regular
    private int lemonadeAmount;
    private  int orangeSodaAmount;
    private  int pepsiAmount;
    private  int rootBeerAmount;
    private  int sierraMistAmount;
    private  int waterAmount;

    private String lemonadeOptions = "";
    private String orangeSodaOptions = "";
    private String pepsiOptions = "";
    private  String rootBeerOptions = "";
    private String sierraMistOptions = "";
    private  String waterOptions = "";





    //account info variables
    private  String firstName = "";
    private String lastName = "";
    private  String emailAddress = "";
    private  String phoneNum = "";
    private  String streetAddress = "";


    private boolean isUsernameTaken = false;






    //variable setters

    public void setOrder(String pizzaType, String toppings, String sides, String drinks, String subtotal, String tax, String total) {
        order = pizzaType + "\n" + toppings +  "\n" + sides +  "\n" + drinks +  "\nSubtotal: " + subtotal + "\nTax: " + tax + "\nOrder Total: " + total;
    }

    public void setOrderWithTip(String tip, String totalAmount) {
        orderWithTip = getOrder() + "\nTip: " + tip + "\nPAID: $" + totalAmount;
    }


    public void setTotal(double input) {
        total = input;
    }

    public void setCrustType(String input) {
        crustType = input;
    }
    public void setSizePizza (String input) {
        sizePizza = input;
    }
    public void setToppings (List input) {
       toppingsList = input;
    }


    public void setBreadstickBitesAmount(int input) {
        breadstickBitesAmount = input;
    }
    public void setBreadSticksAmount(int input) {
        breadSticksAmount = input;
    }
    public void setChipCookieAmount(int input)  {
        chipCookieAmount = input;
    }


    public void setLemonadeAmount(int input){
        lemonadeAmount = input;
    }

    public void setLemonadeOptions(String input) {
        lemonadeOptions = input;
    }
    public void setOrangeSodaAmount(int input) {
        orangeSodaAmount = input;
    }
    public void  setOrangeSodaOptions(String input){
        orangeSodaOptions = input;
    }
    public void  setPepsiAmount(int input){
        pepsiAmount = input;
    }
    public void  setPepsiOptions(String input) {
       pepsiOptions = input;
    }
    public void  setRootBeerAmount(int input) {
        rootBeerAmount = input;
    }
    public void setRootBeerOptions(String input) {
        rootBeerOptions = input;
    }
    public void setSierraMistAmount(int input) {
        sierraMistAmount = input;
    }
    public void setSierraMistOptions(String input) {
        sierraMistOptions = input;
    }
    public void setWaterAmount(int input) {
        waterAmount = input;
    }
    public void setWaterOptions (String input) {
        waterOptions = input;
    }




    public void setFirstName(String input) {
        firstName = input;
    }
    public void setLastName(String input) {
        lastName = input;
    }
    public void  setEmailAddress(String input) {
        emailAddress = input;
    }
    public void  setPhoneNum(String input) {
        phoneNum = input;
    }
    public void  setStreetAddress(String input) {
        streetAddress = input;
    }


    public void setUsernameTaken(boolean input) {
        isUsernameTaken = input;
    }







    //variable getters

    public String getOrder() {
        return order;
    }

    public String getOrderWithTip() {
        return orderWithTip;
    }

    public double getTotal() {
        return total;
    }



    public String getCrustType() {
        return crustType;
    }

    public String getSizePizza () {
        return sizePizza;
    }
    public List getToppings () {
        return toppingsList;
    }

    public int getBreadstickBitesAmount() {
        return breadstickBitesAmount;
    }

    public int getBreadSticksAmount() {
        return breadSticksAmount;
    }
    public int getChipCookieAmount()  {
        return chipCookieAmount;
    }


    public int getLemonadeAmount(){
        return lemonadeAmount;
    }
    public String getLemonadeOptions() {
        return lemonadeOptions;

    }
    public int getOrangeSodaAmount() {
        return orangeSodaAmount;
    }
    public String  getOrangeSodaOptions(){
        return orangeSodaOptions;
    }
    public int  getPepsiAmount(){
        return pepsiAmount;
    }
    public String  getPepsiOptions() {
        return pepsiOptions;
    }
    public int  getRootBeerAmount() {
        return rootBeerAmount;
    }
    public String getRootBeerOptions() {
        return rootBeerOptions;
    }

    public int getSierraMistAmount() {
        return sierraMistAmount;
    }
    public String getSierraMistOptions() {
        return sierraMistOptions;
    }
    public int getWaterAmount() {
        return waterAmount;
    }
    public String getWaterOptions () {
        return waterOptions;
    }



    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String  getEmailAddress() {
        return emailAddress;
    }
    public String  getPhoneNum() {
        return phoneNum;
    }
    public String  getStreetAddress() {
        return streetAddress;
    }

    public boolean  getUsernameTaken() {
        return isUsernameTaken;
    }






}
