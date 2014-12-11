package net.bykov.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * Created by Ievgen on 11/29/2014.
 */
@MappedSuperclass
public abstract class AbstractMainEntity extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private Timestamp created;

    private Timestamp updated;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

}