package com.realdolmen.course.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
@Entity
public class DomesticFlight extends Flight {

    private String airlineCompany;
    @ElementCollection
    private List<String> references = new ArrayList<String>();

    /*Used by JPA*/
    protected DomesticFlight(){}

    public DomesticFlight(String airlineCompany){
        this.airlineCompany = airlineCompany;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }
}
