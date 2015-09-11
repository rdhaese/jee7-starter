package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Status;
import com.realdolmen.course.domain.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
public class TicketRepositoryTest extends DataSetPersistenceTest {

    private TicketRepository ticketRepo;

    @Before
    public void setUp() {
        ticketRepo = new TicketRepository(entityManager());
    }

    /*@Test
    public void canTicketBeCreated() throws Exception {
        Ticket ticket = new Ticket(50.99, Status.PURCHASED);
        ticketRepo.add(ticket);
        fail("todo");
    }*/

    @Test
    public void canTicketBeRetrievedById() throws Exception {
        assertNotNull(ticketRepo.getOnId(1000));
    }

    @Test
    public void canTicketBeUpdated() throws Exception{
        Ticket ticket = ticketRepo.getOnId(2000);

        ticket.setPrice(1d);
        ticketRepo.update(ticket);

        assertEquals(1d, ticketRepo.getOnId(2000).getPrice(), 0.5);
    }

    @Test
    public void canTicketBeDeleted() throws Exception {
        Ticket ticket = ticketRepo.getOnId(2000);

        ticketRepo.delete(ticket);

        assertNull(ticketRepo.getOnId(2000));
    }

    @Test
    public void canTicketBeRefreshed() throws Exception {
        Ticket ticket = ticketRepo.getOnId(2000);

        ticket.setPrice(1d);

        assertNotEquals(1d, ticketRepo.refresh(ticket).getPrice());
    }

  /*  @Test
    public void areTicketOperationsCascadedToPassenger() throws Exception {
        fail("todo");
    }*/
}
