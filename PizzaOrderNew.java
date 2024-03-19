import java.util.Scanner;
public class PizzaOrderNew{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        PizzaOrderNew pizzaOrdering = new PizzaOrderNew();

        String name = sc.nextLine();
        String email = sc.nextLine();
        String address =sc.nextLine();
        long phoneNo =sc.nextLong();

        int noOfPizza = 0;
        int noOfGarlicBread = 0;
        int noOfBeverages = 0;
        float priceOfPizza;
        float priceOfGarlicBread;
        float priceOfBeverages;
        float totalPizzaPrice = 0;
        float totalGarlicBreadPrice = 0;
        float totalBeveragePrice = 0;
        int orderChoice=0;
        int exitChoice=0;


        do{
            pizzaOrdering.displayMenu();
            orderChoice =sc.nextInt();
            switch(orderChoice) {
                case 1:
                    int size = sc.nextInt();
                    noOfPizza = sc.nextInt();
                    priceOfPizza = pizzaOrdering.getPriceOfPizzaBasedOnSize(size);
                    totalPizzaPrice = pizzaOrdering.calculatePriceOfPizza(noOfPizza, priceOfPizza);
                    break;

                case 2:
                    noOfGarlicBread = sc.nextInt();
                    priceOfGarlicBread = pizzaOrdering.getPriceOfGarlicBread();
                    totalGarlicBreadPrice = pizzaOrdering.calculatePriceOfGarlicBread(noOfGarlicBread, priceOfGarlicBread);
                    break;

                case 3:
                    noOfBeverages = sc.nextInt();
                    priceOfBeverages = pizzaOrdering.getPriceOfBeverage();
                    totalBeveragePrice = pizzaOrdering.calculatePriceOfBeverage(noOfBeverages, priceOfBeverages);
                    break;
            }
            exitChoice =sc.nextInt();
        }
        while (exitChoice!=0);

        float totalBillAmount = pizzaOrdering.calculateTotalBill(totalPizzaPrice,totalGarlicBreadPrice,totalBeveragePrice);
        float totalBillAmountAfterDiscount = pizzaOrdering.calculateDiscountAndReturnBillAmount(totalBillAmount);
        pizzaOrdering.displayCustomerDetails(name,email,phoneNo,address);
        pizzaOrdering.displayOrderDetails(noOfPizza,noOfGarlicBread,noOfBeverages,totalBillAmount,totalBillAmountAfterDiscount);
    }
    void displayMenu(){
        System.out.println("Select the items to order");
        System.out.println("SI No    Item Category");
        System.out.println("----------------------");
        System.out.println("1) Pizza");
        System.out.println("   Price of One Regular Pizza : $9.99");
        System.out.println("   Price of One Medium Pizza  : $11.99");
        System.out.println("   Price of One Large Pizza   : $13.99");
        System.out.println("2)  Garlic Bread");
        System.out.println("   Price of One Garlic Bread  : $5.99");
        System.out.println("3)  Beverages");
        System.out.println("   Price of the Beverages     : $1.99");
        System.out.println("Enter 1 for Pizza,2 for Garlic Bread, 3 for Beverages");
    }
    public float getPriceOfPizzaBasedOnSize(int size){
        float prizeOfPizza =0;
        switch(size){
            case 1: prizeOfPizza=9.99f;
                break;
            case 2: prizeOfPizza=11.99f;
                break;
            case 3: prizeOfPizza=13.99f;
                break;
            default:
                System.out.println("Invalid Choice!");
        }
        return prizeOfPizza;
    }

    public float getPriceOfGarlicBread(){
        return 5.99f;
    }

    public float getPriceOfBeverage(){
        return 1.99f;
    }

    public float calculatePriceOfPizza(int noOfPizza, float priceOfPizza)
    {
        return noOfPizza*priceOfPizza;
    }
    public float calculatePriceOfGarlicBread(int noOfGarlicBread, float priceOfGarlicBread)
    {
        return noOfGarlicBread*priceOfGarlicBread;
    }
    public float calculatePriceOfBeverage(int noOfBeverage , float priceOfBeverages)
    {
        return noOfBeverage*priceOfBeverages;
    }
    public float calculateTotalBill(float totalPizzaPrice, float totalGarlicBreadPrice,float totalBeveragePrice)
    {
        return totalPizzaPrice+totalGarlicBreadPrice+totalBeveragePrice;
    }
    public float calculateDiscountAndReturnBillAmount(float totalBillAmount)
    {
        if(totalBillAmount>50)
        {
            return totalBillAmount - (totalBillAmount*10/100);
        }
        else{
            return totalBillAmount;
        }
    }
    public void displayOrderDetails(int noOfPizza, int noOfGarlicBread, int noOfBeverages, float totalBillAmount, float totalBillAmountAfterDiscount)
    {
        System.out.println("Order Details");
        System.out.println("--------------");
        System.out.println("The number of pizzas ordered       :"+ noOfPizza);
        System.out.println("The number of garlic bread ordered :"+ noOfGarlicBread);
        System.out.println("The number of beverages ordered    :"+ noOfBeverages);
        System.out.println("-----------------------------------------------------");
        System.out.println("The Total Bill Amount is      : $"+totalBillAmount);
        if(totalBillAmount>50){
            System.out.println("The Discounted Bill Amount is  : $"+totalBillAmountAfterDiscount);

        }
        else{
            System.out.println("No Discount on Bill");
        }
    }
    void displayCustomerDetails(String name, String email, long phoneNo, String address){
        System.out.println("Customer Details");
        System.out.println("----------------");
        System.out.println("Name of the Customer is :"+ name);
        System.out.println("Email of the Customer is :"+ email);
        System.out.println("Contact No of the Customer is :"+ phoneNo);
        System.out.println("Address of the Customer is  :"+address);
        System.out.println("--------------------------------------------");
    }
}