package application;

import entitites.*;
import services.CustomerService;
import services.FoodService;
import services.OrderService;

import java.util.Scanner;

public class FoodDeliverySystem {
    static Scanner in = new Scanner(System.in);
    //Services
    static FoodService foodServices = new FoodService();
    static CustomerService customerService  = new CustomerService();
    static OrderService orderService = new OrderService();

    //display options and return the choice
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

    //perform the choosen option
    static void doAdminChoice(Byte choice){
        switch (choice){
            //1. Add Restaurant
            case 1  -> {
                System.out.print("Enter Restuarant ID: ");
                int id = in.nextInt();
                in.nextLine();
                System.out.print("Enter Restuarant Name: ");
                String name = in.nextLine();
                Restuarant r = new Restuarant(id,name);
                foodServices.addRestuarant(r);
                System.out.println("Restuarant added Successfully ");
            }
            //2. Add Food Item to Restaurant
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
            //3. Remove Food Item from Restaurant
            case 3 ->{
                System.out.print("Enter Restaurant ID: ");
                int rid = in.nextInt();
                in.nextLine();

                System.out.print("Enter Food Item ID: ");
                int fid = in.nextInt();
                in.nextLine();


                foodServices.removeFoodItemFromRestaurant(rid,fid);
                System.out.println("Food item removed successfully!");

            }
            //4. View Restaurants and Menus
            case 4->{
                System.out.println("Restuarant and Menus:");

                for(Restuarant restuarant :  foodServices.getRestuarants()){
                    restuarant.toString();
                    for(FoodItem food : restuarant.getMenu()){
                       food.toString();
                    }
                }
            }
            //5. View Orders
            case 5 ->{
                System.out.println(orderService.getOrders());
            }
            //6. Add Delivery Person
            case 6 ->{
                System.out.println("Enter Delivery Person ID: ");
                int dpid = in.nextInt();
                in.nextLine();
                System.out.println("Enter Delivery Person Name: ");
                String userName = in.nextLine();
                in.nextLine();
                System.out.println("Enter Contact No: ");
                long contaceNumber = in.nextLong();
                in.nextLine();

                DeliveryPerson deliveryPerson = new DeliveryPerson(dpid,userName,contaceNumber);
                orderService.addDeliveryPerson(deliveryPerson);
                System.out.println("Delivery Person Added Successfully");
            }

            //7. Assign Delivery Person to Order
            case 7->{
                System.out.println("Enter Delivery Person ID: ");
                int dpid = in.nextInt();
                in.nextLine();

                System.out.println("Enter Order ID: ");
                int oid = in.nextInt();
                in.nextLine();
                orderService.assignDeliveryPersonToOrder(oid,dpid);

                for(Order order : orderService.getOrders()){
                    if(order.getOrderId() == oid){
                        order.setStatus("DELIVERY PERSON ASSIGNED");
                    }
                }
            }
            case 8 ->{
                System.out.println("Exit");
                return;
            }
            default -> {
                System.out.print("Enter a Valid Choice: ");
                Byte choose = chooseCustomerMenu();
                doAdminChoice(choose);
            }
        }
    }
    static void doCustomerChoice(Byte choice){
        switch (choice){
            //1. Add Customer
            case  1 ->{
                System.out.println("Enter User ID: ");
                int uid = in.nextInt();
                in.nextLine();
                System.out.println("Enter Username: ");
                String userName = in.nextLine();
                in.nextLine();
                System.out.println("Enter Contact No: ");
                long contaceNumber = in.nextLong();
                in.nextLine();

                Customer newCustomer = new Customer(uid,userName,contaceNumber);
                customerService.addCustomer(newCustomer);
                System.out.println("Customer created successfully!");
            }
            //2. View Food Items
            case 2->{
                //View Food Items
                doAdminChoice((byte) 4);
            }
            //Add food to Cart
            case 3 ->{

                System.out.println("Enter Customer ID");
                int uid = in.nextInt();
                in.nextLine();

                System.out.println("Enter Restuarant ID");
                int rid = in.nextInt();
                in.nextLine();

                System.out.println("Enter Food Item ID: ");
                int fid = in.nextInt();
                in.nextLine();

                System.out.println("Enter Quantity: ");
                int quantity = in.nextInt();
                in.nextLine();

                Customer customer = customerService.getCustomer(uid);
                Cart customerCart = customer.getCart();

                Restuarant restuarant = null;
                for(Restuarant r : foodServices.getRestuarants()){
                    if(r.getId() == rid){
                        restuarant = r;
                        break;
                    }
                }
                if(restuarant == null){
                    System.out.println("Restuarnt not Found... Enter Valid Restuarnt");
                }

                FoodItem food = null;
                for(FoodItem f : restuarant.getMenu()){
                    if(f.getId() == fid){
                        food = f;
                    }
                }

                if(food == null){
                    System.out.println("Food not Found in Restuarnt... Enter Valid Food Item");
                }

                customerCart.addItem(food,quantity);
                System.out.println("Food item added to cart!");

            }
            // View Cart
            case 4 ->{
                System.out.println("Enter Customer ID");
                int uid = in.nextInt();
                in.nextLine();

                Cart cart = customerService.getCustomer(uid).getCart();
                cart.viewCart();
            }
            //Place Order
            case 5 ->{
                System.out.println("Enter Customer ID");
                int uid = in.nextInt();
                in.nextLine();
                Order order = new Order(customerService.getCustomer(uid));
                orderService.placeOrder(order);
                //order property Items is not used Properly
                System.out.println("Order Placed successfully");
            }
            //6. View Orders
            case 6 ->{
                System.out.println(orderService.getOrders());
            }
            default -> {
                System.out.print("Enter a Valid Choice: ");
                Byte choose = chooseCustomerMenu();
                doCustomerChoice(choose);
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
                    Byte customerChoice = chooseCustomerMenu();
                    if(customerChoice == 7){
                        System.out.println("Exiting...");
                        break;
                    }else{
                        doCustomerChoice(customerChoice);
                    }

                }default->{
                    System.out.println("CHoose an Valid option");
                }
            }
        }
    }
}
