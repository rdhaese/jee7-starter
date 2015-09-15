package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.persistence.PassengerRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

/**
 * Created by RDEAX37 on 15/09/2015.
 */

@Named
@RequestScoped
public class PassengerController {

    @Inject
    private PassengerRepository repo;
    private Passenger passenger = new Passenger();

    public List<Passenger> findAll() {
        return repo.findAll();
    }

    public String createPassenger() {
        passenger.setAddress(new Address("sqf","sdfsdf", "sdfsdf", "sdfsdf", "sdifj"));
        passenger.setDateOfBirth(new Date());
        passenger.setPassengerType(PassengerType.OCCASIONAL);
        passenger.setFrequentFlyerMiles(50);
        passenger.setLastFlight(new Date());
        passenger.setLastFlight(new Date());
        repo.add(passenger);
        return "passengers";
    }

    public PassengerRepository getRepo() {
        return repo;
    }

    public void setRepo(PassengerRepository repo) {
        this.repo = repo;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

}
