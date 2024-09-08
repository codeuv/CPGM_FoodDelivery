package application;

import entitites.*;
import services.FoodService;

import java.util.Scanner;

public class FoodDeliverySystem {
    static Scanner in = new Scanner(System.in);
    static FoodService foodServices = new FoodService();

    static Byte choosePanel(){
        System.out.println("CHOOSE YOUR PANEL");
        System.out.println("1. Admin panel");
        System.out.println("2. Customer panel");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        byte choice = in.nextByte();

        return choice;
    }
    static Byte chooseAdminMenu(){
        System.out.println("***Admin Mennu***\n");
        System.out.println("1. Add Restaurant" );
        System.out.println("2. Add Food Item to Restaurant");
        System.out.println("3. Remove Food Item from Restaurant");
        System.out.println("4. View Restaurants and Menus");
        System.out.println("5. View Orders");
        System.out.println("6. Add Delivery Person");
        System.out.println("7. Assign Delivery Person to Order");
        System.out.println("8. Exit");
        byte choice = in.nextByte();
        if(choice <= 0 && choice > 9){
            System.out.println("CHOOSE A VALID OPTION");
            return chooseAdminMenu();
        }
        return choice;
    }
    static Byte chooseCustomerMenu(){
        System.out.println("***Customer Mennu***\n");
        System.out.println("1. Add Customer" );
        System.out.println("2. View Food Items");
        System.out.println("3. Add Food to Cart");
        System.out.println("4. View Cart");
        System.out.println("5. Place Order");
        System.out.println("6. View Orders");
        System.out.println("7. Exit");

        System.out.print("Choose an option: ");
        byte choice = in.nextByte();

        if(choice <= 0 && choice > 8){
            System.out.println("CHOOSE A VALID OPTION");
            return chooseCustomerMenu();
        }
        return choice;
    }

    static void doAdminChoice(Byte choice){
        switch (choice){
            case 1  -> {
                System.out.print("Enter Restuarant ID: ");
                int id = in.nextInt(1);
                in.nextLine();
                System.out.print("Enter Restuarant Name: ");
                String name = in.nextLine();
                Restuarant r = new Restuarant(id,name);
                foodServices.addRestuarant(r);
                System.out.println("Restuarant added Successfully ");
            }
            case 2 ->{
                System.out.print("Enter Restaurant ID: ");
                int rid = in.nextInt();
                in.nextLine();

                System.out.print("Enter Food Item ID: ");
                int fid = in.nextInt();
                in.nextLine();

                System.out.print("Enter Food Item Name: ");
                String foodName = in.nextLine();
                System.out.print("Enter Food Item Price: ");
                double price = in.nextDouble();
                FoodItem food = new FoodItem(fid,foodName,price);
                foodServices.addFoodItemToRestaurant(rid,food);
                System.out.println("Food item added successfully!");
            }
            case 3 ->{

            }
            case 4->{
                System.out.println("Restuarant and Menus:");

                for(Restuarant restuarant :  foodServices.getRestuarants()){
                    restuarant.toString();
                    for(FoodItem food : restuarant.getMenu()){
                       food.toString();
                    }
                }
            }
            case 8 ->{
                System.out.println("Exit");
                return;
            }


        }
    }
    public static void main(String[] args) {
        Byte panel = choosePanel();

        while(panel != 3 ){

            switch (panel){
                case 1 ->{
                    Byte adminChoice = chooseAdminMenu();
                    doAdminChoice(adminChoice);
                }
                case 2 -> {
                    chooseCustomerMenu();
                    break;
                }default->{
                    System.out.println("CHoose an Valid option");
                }
            }
        }
    }
}
