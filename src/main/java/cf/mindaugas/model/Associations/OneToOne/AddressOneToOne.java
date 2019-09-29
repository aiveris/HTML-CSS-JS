package cf.mindaugas.model.Associations.OneToOne;

import javax.persistence.*;

@Entity
public class AddressOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String country;
    private String city;
    private String street;

    @OneToOne(mappedBy="address") // slave
    private UserOneToOne user;

    public AddressOneToOne() {
    }

    public AddressOneToOne(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }
}