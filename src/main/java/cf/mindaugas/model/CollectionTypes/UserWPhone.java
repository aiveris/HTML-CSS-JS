package cf.mindaugas.model.CollectionTypes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
public class UserWPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private int height;
    private int age;
    @ElementCollection
    private List<String> phones = new ArrayList<>();

    public UserWPhone() {}

    public UserWPhone(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public long getId(){
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}