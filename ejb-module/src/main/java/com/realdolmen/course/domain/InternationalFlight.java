package com.realdolmen.course.domain;

import javax.persistence.Entity;


/**
 * Created by RDEAX37 on 10/09/2015.
 */
@Entity
public  class InternationalFlight extends Flight {
    private boolean blacklisted;
    private String regulations;

    /*Used by JPA*/
    protected InternationalFlight() {
    }

    public InternationalFlight(boolean blacklisted, String regulations) {
        this.blacklisted = blacklisted;
        this.regulations = regulations;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }
}

