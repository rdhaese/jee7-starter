package com.realdolmen.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
@Entity
public class Plane extends AbstractEntity {


    private String type;

    /*Used by JPA*/
    protected Plane(){}

    public Plane(String type){
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
