package entitites;

public class Customer extends User{
    public Customer(int userId, String userName, long contactNo) {
        super(userId, userName, contactNo);
    }

    private Cart cart = new Cart();

    public Cart getCart() {
        return cart;
    }
}
