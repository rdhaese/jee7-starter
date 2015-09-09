package com.realdolmen.course.domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * Created by RDEAX37 on 9/09/2015.
 */
@Embeddable
public class CreditCard implements Serializable{

    private String number;
    private String expireDate;
    private int controlNumber;
    @Enumerated (value = EnumType.STRING)
    private CreditCardType creditCardType;

    /*Used by JPA*/
    protected CreditCard(){}

    public CreditCard(String number, String expireDate, int controlNumber, CreditCardType creditCardType) {
        this.number = number;
        this.expireDate = expireDate;
        this.controlNumber = controlNumber;
        this.creditCardType = creditCardType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public int getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(int controlNumber) {
        this.controlNumber = controlNumber;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCard that = (CreditCard) o;

        if (getControlNumber() != that.getControlNumber()) return false;
        if (!getNumber().equals(that.getNumber())) return false;
        if (!getExpireDate().equals(that.getExpireDate())) return false;
        return getCreditCardType() == that.getCreditCardType();

    }

    @Override
    public int hashCode() {
        int result = getNumber().hashCode();
        result = 31 * result + getExpireDate().hashCode();
        result = 31 * result + getControlNumber();
        result = 31 * result + getCreditCardType().hashCode();
        return result;
    }
}
