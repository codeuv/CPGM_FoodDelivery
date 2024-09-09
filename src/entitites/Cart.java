package entitites;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<FoodItem, Integer> items;
    public Cart() {
        items = new HashMap<>();
    }

    public void addItem(FoodItem foodItem ,int quantity){
        items.put(foodItem, items.getOrDefault(foodItem, 0) + quantity);
    }

    public void removeItem(FoodItem fooditem){
        if( items.containsKey(fooditem)){
            items.remove(fooditem);
        }
        //raise error if needed
    }

    Map<FoodItem,Integer> getItems(){
        return new HashMap<>(items);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }

    public void viewCart(){
        System.out.println("Cart");
        double totalCost = 0d;
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            double cost = entry.getKey().getPrice() * entry.getValue();

            System.out.println("Food Item: " + entry.getKey() + ","
                    + " Quantity: " + entry.getValue()
                    + " Cost"+cost);
            totalCost += cost;
        }
        System.out.println("Total Cost: "+totalCost);

    }
}
