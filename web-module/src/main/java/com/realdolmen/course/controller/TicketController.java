package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;
import com.realdolmen.course.persistence.PassengerRepository;
import com.realdolmen.course.persistence.TicketRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by RDEAX37 on 15/09/2015.
 */
@Named
@RequestScoped
public class TicketController {

    @Inject
    private TicketRepository repo;
    @Inject
    private PassengerRepository passengerRepo;


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private Ticket ticket = new Ticket();


    public String newTicket(long passengerId){
        ticket.setPassenger(passengerRepo.getOnId(passengerId));
        return "new-ticket";
    }

    public String createTicket(){
        repo.add(ticket);
        return "passengers";
    }

}
