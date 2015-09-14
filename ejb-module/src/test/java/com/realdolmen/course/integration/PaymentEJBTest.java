package com.realdolmen.course.integration;

import com.realdolmen.course.persistence.PaymentEJBRemote;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.Remote;
import javax.naming.NamingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by RDEAX37 on 14/09/2015.
 */
public class PaymentEJBTest extends RemoteIntegrationTest {

    private PaymentEJBRemote ejb;

    @Before
    public void setUp() throws NamingException {
        ejb = lookup("ear-module-1.1/ejb-module-1.1/PaymentEJB!com.realdolmen.course.persistence.PaymentEJBRemote");
    }

    @Test
    public void isPayingAsynchronous() throws ExecutionException, InterruptedException {
        Future<String> paymentStatus = ejb.payByCreditCard();
        assertNull(null);
        assertEquals("Payed", paymentStatus.get());

    }
}
