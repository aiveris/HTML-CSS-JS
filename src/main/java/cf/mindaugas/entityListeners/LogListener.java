package cf.mindaugas.entityListeners;

import javax.persistence.PostPersist;

public class LogListener {

    @PostPersist
    public void prepersist(Object movie){
        System.out.println("postpersist called from LogListener");
    }
}