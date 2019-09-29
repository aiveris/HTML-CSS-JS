package cf.mindaugas.entityListeners;
import javax.persistence.PrePersist;

public class AuditListener {

    @PrePersist
    public void prepersist(Object movie){
        System.out.println("prepersist called from AuditListener");
    }
}