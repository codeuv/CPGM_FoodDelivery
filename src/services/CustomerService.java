package services;

import entitites.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customerList = new ArrayList<>( ) ;
    public void addCustomer (Customer customer) {
        customerList.add(customer);
    }

    public Customer getCustomer (int userId) {
        for(Customer c : customerList){
            if(c.getUserId() ==  userId){
                return c;
            }
        }
        //raise an error
        System.out.println("NO USERNAME WITH "+userId+"FOUND");
        return null;
    }
    public List<Customer> getCustomers ( ) {
        return customerList;
    }
}
