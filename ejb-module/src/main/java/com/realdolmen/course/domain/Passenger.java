package com.realdolmen.course.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RDEAX37 on 9/09/2015.
 */
@Entity
@NamedQuery(name = "Passenger.getAllPassengers", query = "SELECT p FROM Passenger p")
public class Passenger extends AbstractEntity {

    @Column(nullable = false, updatable = false)
    private String ssn;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Embedded
    private Address address;
    @ElementCollection
    @CollectionTable(name = "creditcards")
    private List<CreditCard> creditCards = new ArrayList<CreditCard>();
    @ElementCollection
    @CollectionTable(name = "preferences")
    @Column(name = "preference")
    private List<String> preferences = new ArrayList<String>();
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
    @OneToMany(mappedBy = "passenger", cascade = CascadeType.REMOVE)
    private List<Ticket> tickets = new ArrayList<Ticket>();
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateLastUpdated;

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
        this.passengerType = passengerType;
        this.lastFlight = lastFlight;
    }

    @PrePersist
    @PreUpdate
    private void updateDateLastUpdated() {
        dateLastUpdated = new Date();
    }

    @PostLoad
    @PostPersist
    @PostUpdate
    private void calculateAge() {
        LocalDate now = LocalDate.now();
        LocalDate birth = new java.sql.Date(dateOfBirth.getTime()).toLocalDate();
        age = Period.between(birth, now).getYears();
    }

    public void addCreditCard(CreditCard creditCard){
        creditCards.add(creditCard);
    }

    public void removeCreditCard(CreditCard creditCard){
        creditCards.remove(creditCard);
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket){
        tickets.remove(ticket);
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
        calculateAge();
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getAge() {
        return age;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
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
