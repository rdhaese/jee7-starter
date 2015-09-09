package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by RDEAX37 on 9/09/2015.
 */
@Entity
@NamedQuery(name="Passenger.getAllPassengers", query="SELECT p FROM Passenger p")
public class Passenger implements Serializable {


    @EmbeddedId
    private PassengerId passengerId;
    private String firstName;
    private Integer frequentFlyerMiles;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    /*used by JPA*/
    protected Passenger(){}

    public Passenger( String ssn, String firstName, String lastName, Integer frequentFlyerMiles){
        passengerId = new PassengerId(ssn,lastName);
        this.firstName = firstName;
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public PassengerId getPassengerId() {

        return passengerId;
    }

    public void setPassengerId(PassengerId passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (!getPassengerId().equals(passenger.getPassengerId())) return false;
        return !(getFirstName() != null ? !getFirstName().equals(passenger.getFirstName()) : passenger.getFirstName() != null);

    }

    @Override
    public int hashCode() {
        int result = getPassengerId().hashCode();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        return result;
    }
}
