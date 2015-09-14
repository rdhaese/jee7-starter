package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.*;

import javax.ejb.Remote;
import javax.ejb.Remove;
import java.util.Date;

/**
 * Created by RDEAX37 on 14/09/2015.
 */

@Remote
public interface PassengerStatefulEJBRemote {

    Passenger getPassenger();
     void createPassengers(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, byte[] picture, Date dateOfBirth, PassengerType passengerType, Date lastFlight);
     void pickPassenger(long id);
     void setAddress(Address address);
     void addCreditCard(CreditCard creditCard);
     void addTicket(double price, Status status);
    void checkOut();
}
