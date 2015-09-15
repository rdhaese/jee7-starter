package com.realdolmen.course.integration;

import com.realdolmen.course.domain.Ticket;
import org.junit.Test;

import javax.jms.JMSException;

/**
 * Created by RDEAX37 on 15/09/2015.
 */
public class TicketAdjusterTest extends RemoteJmsTest {

    @Test
    public void isTicketAdjusted() throws JMSException {
        producer.send(session.createTextMessage("1000,50/n2000,200/n9999,300"));
        //Check database
    }
}
