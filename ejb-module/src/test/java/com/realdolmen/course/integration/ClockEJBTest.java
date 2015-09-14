package com.realdolmen.course.integration;

import com.realdolmen.course.domain.ClockEJBRemote;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by RDEAX37 on 14/09/2015.
 */
public class ClockEJBTest extends RemoteIntegrationTest{


    private ClockEJBRemote ejb;

    @Before
    public void setUp() throws NamingException {
        ejb = lookup("ear-module-1.1/ejb-module-1.1/ClockEJB!com.realdolmen.course.domain.ClockEJBRemote");
    }
    @Test
    public void isTimePrinted(){
        //Check console
    }
}
