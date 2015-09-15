package com.realdolmen.course.consumer;

import com.realdolmen.course.domain.PassengerEJB;
import com.realdolmen.course.domain.PassengerEJBRemote;
import com.realdolmen.course.domain.Status;
import com.realdolmen.course.domain.Ticket;
import com.realdolmen.course.persistence.TicketRepository;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by RDEAX37 on 15/09/2015.
 */

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/MyQueue"),
})
public class TicketAdjuster implements MessageListener {

    @EJB
    private TicketRepository repo;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            String[] lines = textMessage.getText().split("/n");
            for (String line : lines) {
                parseLine(line);
            }
        } catch (JMSException e) {
            throw new RuntimeException("Deal with this", e);
        }
    }

    private void parseLine(String line) {
        String[] data = line.split(",");
        double price = Double.parseDouble(data[1]);
        Ticket ticket = repo.getOnId(Long.parseLong(data[0]));
        if (ticket != null){
            ticket.setPrice(price);
            System.out.println("Ticket adjusted");
        } else {
            createNew(price);
        }
    }

    private void createNew(double price) {
        Ticket ticket = new Ticket(price, Status.PENDING);
        repo.add(ticket);
        System.out.println("New ticket created");
    }
}
