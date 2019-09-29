package jdbchibernatemongodriver.cqrs.simplecqrs;

import java.util.Locale;

public interface CustomerWriteService {
    void makeCustomerPreferred(long CustomerId);
    void changeCustomerLocale(long CustomerId, Locale NewLocale);
    void createCustomer(String Name);
    void editCustomerDetails(CustomerDetails customerDetails);
}

class Customer {}

class CustomerDetails {}

class CustomerSet {}