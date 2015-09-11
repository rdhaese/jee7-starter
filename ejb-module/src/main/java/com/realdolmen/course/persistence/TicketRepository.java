package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
public class TicketRepository {

    private EntityManager em;

    public TicketRepository(EntityManager em){
        this.em = em;
    }

    public void add(Ticket ticket) {
        em.persist(ticket);
    }

    public Ticket getOnId(long i) {
        Ticket t = em.find(Ticket.class, i);
        return t;
    }

    public void update(Ticket ticket) {
        em.merge(ticket);
    }

    public void delete(Ticket ticket) {
        em.remove(em.merge(ticket));
    }

    public Ticket refresh(Ticket ticket) {
        em.refresh(ticket);
        return ticket;
    }
}
