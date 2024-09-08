package entitites;

public class User {
    private int userId;
    private String userName;
    private long ContactNo;

    public User(int userId, String userName, long contactNo) {
        this.userId = userId;
        this.userName = userName;
        ContactNo = contactNo;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public long getContactNo() {
        return ContactNo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
