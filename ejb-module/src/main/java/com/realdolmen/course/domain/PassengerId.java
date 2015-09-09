package com.realdolmen.course.domain;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by RDEAX37 on 9/09/2015.
 */
@Embeddable
public class PassengerId implements Serializable{

    private String ssn;

    private String lastName;

    /*for JPA*/
    protected PassengerId(){}

    public PassengerId(String ssn, String lastName){
        this.ssn = ssn;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerId that = (PassengerId) o;

        if (!getSsn().equals(that.getSsn())) return false;
        return getLastName().equals(that.getLastName());

    }

    @Override
    public int hashCode() {
        int result = getSsn().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }

    public String getSsn() {

        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
