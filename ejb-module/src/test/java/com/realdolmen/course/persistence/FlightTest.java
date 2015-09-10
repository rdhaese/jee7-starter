package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.DomesticFlight;
import com.realdolmen.course.domain.Flight;
import org.junit.Test;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
public class FlightTest extends DataSetPersistenceTest{

    @Test
    public void canAFlightBePersisted(){
        Flight flight = new DomesticFlight("sabena");
        entityManager().persist(flight);
        assertNotNull(flight.getId());
    }

    @Test
    public void canADomesticFlightBeFound(){
        fail();
    }

    @Test
    public void canAnInternationalFlightBeFound(){
        fail();
    }
}
