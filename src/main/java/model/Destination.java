package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "destination")
public class Destination {

    public Destination(String id, String location) {
        this.id = id;
        this.location = location;
    }
    public Destination(String location) {
        this.location = location;
    }

    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String location;

    public Destination() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
