package com.realdolmen.course.domain;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by RDEAX37 on 11/09/2015.
 */
@Remote
public interface PassengerEJBRemote {

    List<Passenger> findPassengers();
    Passenger findPassengerById(Long id);
    Passenger createPassenger(Passenger passenger);
    void deletePassenger(Passenger passenger);
    Passenger updatePassenger(Passenger passenger);
}
