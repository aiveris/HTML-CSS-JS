package cf.mindaugas.model.BasicTypes;

import org.hibernate.annotations.Type;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;

@Entity(name = "Contact")
public class Contact {
    @Id
    private Integer id;
    private Name name;
    private String notes;
    private URL website;

    @Type(type="boolean") // basic type
    //  `starred` bit(1) NOT NULL, in MYSQL
    private boolean starred;

    public Contact(Integer id, Name name, String notes, URL website, boolean starred) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.website = website;
        this.starred = starred;
    }

    public Contact() { }

    //Getters and setters are omitted for brevity

    public Contact(Name name, URL website, boolean starred) {
        this.name = name;
        this.website = website;
        this.starred = starred;
    }
}
