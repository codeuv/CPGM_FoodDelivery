package services;


import entitites.FoodItem;
import entitites.Restuarant;
import java.util.ArrayList;
import java.util.List;

public class FoodService {
    private List<Restuarant> restuarants = new ArrayList<>();
    public void addRestuarant(Restuarant restuarant){
        restuarants.add(restuarant);
    }
    public List<FoodItem> getAllFoodItems(){
        List<FoodItem> allFoodItems = new ArrayList<>() ;
        for (Restuarant restaurant : restuarants) {
            allFoodItems.addAll(restaurant.getMenu());
        }
        return allFoodItems ;
    }
    public void addFoodItemToRestaurant(int restuarantID,FoodItem foodItem) {
        for(Restuarant r : restuarants){
            if( r.getId() == restuarantID){
                r.addFoodItem(foodItem);
            }
        }
        System.out.println("RestuarantID Not Found");
    }
    public void removeFoodItemFromRestaurant (int restuarantID,FoodItem foodItem){
        for(Restuarant r : restuarants){
            if( r.getId() == restuarantID){
                r.removeFoodItem(restuarantID);
            }
        }
        System.out.println("Restuarant ID Not Found");
    }

    public List<Restuarant> getRestuarants() {
        return restuarants;
    }
}
