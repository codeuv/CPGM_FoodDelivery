package entitites;

import java.util.ArrayList;
import java.util.List;

public class Restuarant {
    private int id ;
    private String name;
    private List<FoodItem> menu;

    public Restuarant(int id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "Restuarant id: " +  id +
                ", name: " + name + "\n" ;
    }

    public void addFoodItem(FoodItem fooditem){
        menu.add(fooditem);
    }

    public void removeFoodItem(int id){
        for(FoodItem f : this.menu){
            if(f.getId() == id){
                menu.remove(f);
                return ;
            }
        }
    }
}
