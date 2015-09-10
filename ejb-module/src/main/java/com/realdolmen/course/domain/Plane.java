package com.realdolmen.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by RDEAX37 on 10/09/2015.
 */
@Entity
public class Plane implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String type;

    protected Plane(){}

    public Plane(String type){
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
