package cf.mindaugas.model.Associations.OneToOne;

import javax.persistence.*;

@Entity
public class UserOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    // whoever owns the foreign key column gets the @JoinColumn annotation.
    // so the owner in our case is the User class.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private AddressOneToOne address;

    public UserOneToOne() {
    }

    public UserOneToOne(String name, String email, AddressOneToOne address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setAddress(AddressOneToOne address) {
        this.address = address;
    }
}