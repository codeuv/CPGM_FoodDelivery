package entitites;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<FoodItem, Integer> items;
    public Cart() {
        items = new HashMap<>();
    }

    void addItem(FoodItem foodItem ,int quantity){
        items.put(foodItem, items.getOrDefault(foodItem, 0) + quantity);
    }

    void removeItem(FoodItem fooditem){
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
}
