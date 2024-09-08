package entitites;

public class DeliveryPerson {

    private int deliveryPersonID ;
    private String name;
    private long contactNo;

    public DeliveryPerson(int deliveryPersonID, String name, long contactNo) {
        this.deliveryPersonID = deliveryPersonID;
        this.name = name;
        this.contactNo = contactNo;
    }

    public int getDeliveryPersonID() {
        return deliveryPersonID;
    }

    public String getName() {
        return name;
    }

    public long getContactNo() {
        return contactNo;
    }

    @Override
    public String toString() {
        return "DeliveryPerson{" +
                "deliveryPersonID=" + deliveryPersonID +
                ", name='" + name + '\'' +
                ", contactNo=" + contactNo +
                '}';
    }
}
