package jdbchibernatemongodriver.cqrs.traditionalarchitecture;

import java.util.Locale;

public interface CustomerService {
    void makeCustomerPreferred(long CustomerId);
    Customer getCustomer(long CustomerId);
    CustomerSet getCustomersWithName(String Name);
    CustomerSet getPreferredCustomers();
    void changeCustomerLocale(long CustomerId, Locale NewLocale);
    void createCustomer(String Name);
    void editCustomerDetails(CustomerDetails customerDetails);
}

class Customer {}

class CustomerDetails {}

class CustomerSet {}
