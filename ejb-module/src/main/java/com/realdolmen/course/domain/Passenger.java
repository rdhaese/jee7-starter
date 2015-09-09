package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * Created by RDEAX37 on 9/09/2015.
 */
@Entity
@NamedQuery(name = "Passenger.getAllPassengers", query = "SELECT p FROM Passenger p")
public class Passenger implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, updatable = false)
    private String ssn;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    private Integer frequentFlyerMiles;
    @Lob
    private byte[] picture;
    @Column(nullable = false, updatable = false)
    @Temporal(value = TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private int age;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PassengerType passengerType;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastFlight;

    /*used by JPA*/
    protected Passenger() {
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, byte[] picture, Date dateOfBirth, PassengerType passengerType, Date lastFlight) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.picture = picture;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.passengerType = passengerType;
        this.lastFlight = lastFlight;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = new Date(dateOfBirth.getTime());
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getAge(){
        LocalDate now = LocalDate.now();
        LocalDate birth = LocalDate.from(((java.sql.Date)dateOfBirth).toLocalDate());
        return Period.between(birth,now).getYears();
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        return getSsn().equals(passenger.getSsn());

    }

    @Override
    public int hashCode() {
        return getSsn().hashCode();
    }
}