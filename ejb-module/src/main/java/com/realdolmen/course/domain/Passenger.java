package com.realdolmen.course.domain;

import javax.persistence.*;

/**
 * Created by RDEAX37 on 9/09/2015.
 */
@Entity
@NamedQuery(name="Passenger.getAllPassengers", query="SELECT p FROM Passenger p")
public class Passenger {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable=false)
    private String ssn;

    private String firstName;
    private String lastName;
    private Integer frequentFlyerMiles;

    /*used by JPA*/
    protected Passenger(){}

    public Passenger( String ssn, String firstName, String lastName, Integer frequentFlyerMiles){
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }
}
