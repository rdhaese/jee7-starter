package com.realdolmen.course.integration;

import com.realdolmen.course.domain.*;
import com.realdolmen.course.persistence.PassengerStatefulEJB;
import com.realdolmen.course.persistence.PassengerStatefulEJBRemote;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.NoSuchEJBException;
import javax.naming.NamingException;
import java.util.Date;

/**
 * Created by RDEAX37 on 14/09/2015.
 */
public class PassengerStatefulEJBTest extends RemoteIntegrationTest {

    private PassengerStatefulEJBRemote ejb;

    @Before
    public void setUp() throws NamingException {
        ejb = lookup("ear-module-1.1/ejb-module-1.1/PassengerStatefulEJB!com.realdolmen.course.persistence.PassengerStatefulEJBRemote");
    }

    @Test
    public void canPassengerBeCreated(){
        assertNull(ejb.getPassenger());
        ejb.createPassengers("sdqsd", "sdfsdf", "dsofksdf", 50, null, new Date(), PassengerType.OCCASIONAL, new Date());
        assertNotNull(ejb.getPassenger());
    }

    @Test
    public void canPassengerBePicked(){
        ejb.pickPassenger(1000L);
        assertEquals("12345", ejb.getPassenger().getSsn());
    }

    @Test
    public void canAddressBeSet(){
        ejb.createPassengers("sdqsd", "sdfsdf", "dsofksdf", 50, null, new Date(), PassengerType.OCCASIONAL, new Date());
        assertNotNull(ejb.getPassenger());
        assertNull(ejb.getPassenger().getAddress());
        ejb.setAddress(new Address("dspofksdfk", "dspofksdfk", "dspofksdfk", "dspofksdfk", "dspofksdfk"));
        assertNotNull(ejb.getPassenger().getAddress());
    }

    @Test
    public void canCreditCardBeAdded(){
        ejb.createPassengers("sdqsd", "sdfsdf", "dsofksdf", 50, null, new Date(), PassengerType.OCCASIONAL, new Date());
        assertNotNull(ejb.getPassenger());
        assertEquals(0, ejb.getPassenger().getCreditCards().size());
        ejb.addCreditCard(new CreditCard("sidjfsdfj", "siqdjisfj", 5, CreditCardType.AMEX));
        ejb.addCreditCard(new CreditCard("sidjfsdfj", "siqdjisfj", 5, CreditCardType.VISA));
        ejb.addCreditCard(new CreditCard("sidjfsdfj", "siqdjisfj", 5, CreditCardType.MASTER));
        assertEquals(3, ejb.getPassenger().getCreditCards().size());
    }

    @Test
    public void canTicketBeAdded(){
        ejb.createPassengers("sdqsd", "sdfsdf", "dsofksdf", 50, null, new Date(), PassengerType.OCCASIONAL, new Date());
        assertNotNull(ejb.getPassenger());
        assertEquals(0, ejb.getPassenger().getTickets().size());
        ejb.addTicket(1.50, Status.PURCHASED);
        ejb.addTicket(1.50, Status.PURCHASED);
        ejb.addTicket(1.50, Status.PENDING);
        assertEquals(3, ejb.getPassenger().getTickets().size());
    }

    @Test
    public void canBeCheckedOutNewPassenger(){
        ejb.createPassengers("sdqsd", "sdfsdf", "dsofksdf", 50, null, new Date(), PassengerType.OCCASIONAL, new Date());
        ejb.setAddress(new Address("dspofksdfk", "dspofksdfk", "dspofksdfk", "dspofksdfk", "dspofksdfk"));
        ejb.addCreditCard(new CreditCard("sidjfsdfj", "siqdjisfj", 5, CreditCardType.AMEX));
        ejb.addTicket(1.50, Status.PURCHASED);
        ejb.checkOut();
        assertEquals(4, entityManager().createQuery("SELECT p FROM Passenger p").getResultList().size());
    }

   /* @Test
    public void canBeCheckedOutOldPassenger(){
        ejb.pickPassenger(1000L);
        ejb.setAddress(new Address("dspofksdfk", "dspofksdfk", "dspofksdfk", "dspofksdfk", "dspofksdfk"));
        ejb.addCreditCard(new CreditCard("sidjfsdfj", "siqdjisfj", 5, CreditCardType.AMEX));
        ejb.addTicket(1.50, Status.PURCHASED);
        ejb.checkOut();
        assertEquals("12345", entityManager().find(Passenger.class, 1000L).getSsn());
    }*/

    @Test (expected = NoSuchEJBException.class)
    public void isNoSuchEJBExceptionThrownAfterCheckout(){
        ejb.createPassengers("sdqsd", "sdfsdf", "dsofksdf", 50, null, new Date(), PassengerType.OCCASIONAL, new Date());
        ejb.setAddress(new Address("dspofksdfk", "dspofksdfk", "dspofksdfk", "dspofksdfk", "dspofksdfk"));
        ejb.addCreditCard(new CreditCard("sidjfsdfj", "siqdjisfj", 5, CreditCardType.AMEX));
        ejb.addTicket(1.50, Status.PURCHASED);
        ejb.checkOut();
        ejb.getPassenger(); //Should throw NoSuchEJBException
    }
}
