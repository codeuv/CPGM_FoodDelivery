package services;

import entitites.FoodItem;
import entitites.*;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>() ;
    private List<DeliveryPerson> deliveryPersons = new ArrayList<>();

    public void placeOrder(Order order){
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addDeliveryPerson(DeliveryPerson deliveryPerson){
        deliveryPersons.add(deliveryPerson);
    }

    public List<DeliveryPerson> getDeliveryPersons() {
        return deliveryPersons;
    }

    public void assignDeliveryPersonToOrder(int orderId ,int deliveryPersonId){
        Order order = null;
        for (Order o : orders) {
            if (o.getOrderId() == orderId) {
                order = o;
                break;
            }
        }
        if (order == null) {
            System.out.println("Order with ID " + orderId + " not found.");
            return;
        }

        DeliveryPerson deliveryPerson = null;
        for (DeliveryPerson dp : deliveryPersons) {
            if (dp.getDeliveryPersonID() == deliveryPersonId) {
                deliveryPerson = dp;
                break;
            }
        }

        if (deliveryPerson == null) {
            System.out.println("Delivery Person with ID " + deliveryPersonId + " not found.");
            return;
        }
        order.setDeliveryPerson(deliveryPerson);
        System.out.println("Delivery Person " + deliveryPerson.getName() + " assigned to Order ID " + orderId);
    }
}
