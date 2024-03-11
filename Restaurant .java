
package restaurant;

import java.util.ArrayList;
import java.util.Scanner;

class Food {
    private String name;
    private double price;
    private int stock;

    public Food(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }
}



class Menu {
    private ArrayList<Food> menuList;
    private int choose;
    private int quantity;
    double subTotal;
    String again;
    
    Scanner sc = new Scanner(System.in);

    public ArrayList<Food> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<Food> menuList) {
        this.menuList = menuList;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void generateBill() {
        System.out.println();
        System.out.println("******THANK YOU FOR ORDERING*******");
        
    }

    public void print() {
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println();

            Food food = menuList.get(i);
            System.out.println((i + 1) + ". " + food.getName() + " - Rs." + food.getPrice() + " - Stock: " + food.getStock());
        }

        System.out.println("\n" + "Please Select the Food item");
        choose = sc.nextInt();
        System.out.println();

        switch (choose) {
            case 1:
                System.out.println("---You have selected " + menuList.get(0).getName() + "---" + "\n");
                System.out.println("Enter your desired quantity");
                quantity = sc.nextInt();
                subTotal += quantity * menuList.get(0).getPrice();
                break;

            case 2:
                System.out.println("---You have selected"+ menuList.get(1).getName()+ "---" + "\n");
                System.out.println("Enter your desired quantity");
                quantity = sc.nextInt();
                subTotal += quantity * menuList.get(1).getPrice();
                break;

            case 3:
                System.out.println("---You have selected "+ menuList.get(2).getName()+ "---" + "\n");
                System.out.println("Enter your desired quantity");
                quantity = sc.nextInt();
                subTotal += quantity * menuList.get(2).getPrice();
                break;

            case 4:
                System.out.println("---You have selected "+ menuList.get(3).getName()+ "---" + "\n");
                System.out.println("Enter your desired quantity");
                quantity = sc.nextInt();
                subTotal += quantity * menuList.get(3).getPrice();
                break;

            case 5:
                System.out.println("---You have selected "+ menuList.get(4).getName()+ "---" + "\n");
                System.out.println("Enter your desired quantity");
                quantity = sc.nextInt();
                subTotal += quantity * menuList.get(4).getPrice();
                break;

            case 6:
                System.out.println("---You have selected "+ menuList.get(5).getName()+ "---" + "\n");
                System.out.println("Enter your desired quantity");
                quantity = sc.nextInt();
                subTotal += quantity * menuList.get(5).getPrice();
                break;


            default:
                System.out.println("Invalid choice. Please enter valid numbers 1, 2, 3, 4, 5, 6, or 7" + "\n");
        }

        System.out.println();
        System.out.println("Do you wish to order anything else (Y/N): ");
        again = sc.next();
        if (again.equalsIgnoreCase("Y")) {
            print();
            System.out.println("***Your total amount: Rs." + subTotal + "***");
        } else if (again.equalsIgnoreCase("N")) {
            FoodOffer foodOffer = new FoodOffer();
            foodOffer.generateBill(subTotal);
            System.exit(1);
        } else {
            System.out.println("Invalid choice. Please enter valid numbers 1, 2, 3, 4, 5, 6, or 7" + "\n");
        }
    }
}

class FoodOffer extends Menu {
    double offerValue = 5000;

    public FoodOffer() {
        super();
    }

   
    public void generateBill(double subTotal) {
        super.generateBill();
        if (subTotal >= offerValue) {
            double discount = subTotal * 0.10;
            double discountTotal= subTotal - discount ;
            
            System.out.println("Total Amount Before Discount: Rs." + subTotal);
            System.out.println("Discount Applied(10%): Rs." + discount);
            System.out.println("Total Amount After Discount: Rs." + discountTotal);
            
        } else {
            System.out.println("your total amount is : Rs."+subTotal);
        }
    }
}

public class Restaurant {
    static ArrayList<Food> menuList;

    public static void main(String[] args) {
        
        //add the food item in array list
        menuList = new ArrayList<>();
        menuList.add(new Food("Pizza", 500.00, 20));
        menuList.add(new Food("Burger", 580.00, 25));
        menuList.add(new Food("Kottu", 750.00, 32));
        menuList.add(new Food("Fried Rice", 850.00, 16));
        menuList.add(new Food("Sandwich", 320.00, 15));
        menuList.add(new Food("Red Eye Coffee", 150.00, 20));
        

        boolean x = true;
        while (x) {
            System.out.println("\n" + "*****WELCOME TO OUR RESTAURANT*****");
            System.out.println("***********************************");
            System.out.println("\n" + "Choose your options\n"
                    + "1-->MenuList\n"
                    + "2-->Exit\n");
            
            Scanner sc = new Scanner(System.in);
            
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\n" + "***ITEM***\t" + "***PRICE***\t" + "***STOCK***");
                    Menu objMenu = new Menu();
                    objMenu.setMenuList(menuList);
                    objMenu.print();

                    FoodOffer objOffer = new FoodOffer();
                    objOffer.generateBill();
                    break;

                case 2:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }
    }
}














