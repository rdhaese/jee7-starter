package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.persistence.FlightRepo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by RDEAX37 on 15/09/2015.
 */
@Named
@RequestScoped
public class FlightController {

    @Inject
    private FlightRepo repo;

    public List<Flight> getAllFlights(){
        return repo.findAll();
    }
}
