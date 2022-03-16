package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vacation")
public class Vacation {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String details;

    @Column
    private Float price;

    @Column
    private Integer nrAvailable;

    @Column
    private Date periodStart;

    @Column
    private Date periodEnd;

    @ManyToOne
    @JoinColumn
    private Destination destination;



    public Vacation(
            String id,
            String name,
            String details,
            Float price,
            Integer nrAvailable,
            Date periodStart,
            Date periodEnd,
            Destination destination
    ) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.price = price;
        this.nrAvailable = nrAvailable;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.destination = destination;
    }

    public Vacation(
            String name,
            String details,
            Float price,
            Integer nrAvailable,
            Date periodStart,
            Date periodEnd,
            Destination destination
    ) {
        this.name = name;
        this.details = details;
        this.price = price;
        this.nrAvailable = nrAvailable;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.destination = destination;
    }

    public  Vacation(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getNrAvailable() {
        return nrAvailable;
    }

    public void setNrAvailable(Integer nrAvailable) {
        this.nrAvailable = nrAvailable;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
