package cf.mindaugas.model.BasicTypes;

import javax.persistence.Embeddable;

@Embeddable // ... here we we illustrate the embeddable type
public class Name {
    private String first;
    private String middle;
    private String last;

    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public Name() { }

    // getters and setters omitted
}