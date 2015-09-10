package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.DomesticFlight;
import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.InternationalFlight;
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
        Flight flight = entityManager().find(Flight.class, 1000L);
        assertTrue(flight instanceof DomesticFlight);
    }

    @Test
    public void canAnInternationalFlightBeFound(){
        Flight flight = entityManager().find(Flight.class, 1001L);
        assertTrue(flight instanceof InternationalFlight);
    }
}
