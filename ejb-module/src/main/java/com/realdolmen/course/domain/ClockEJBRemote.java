package com.realdolmen.course.domain;

import javax.ejb.Remote;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * Created by RDEAX37 on 14/09/2015.
 */
@Remote
public interface ClockEJBRemote extends Serializable{

    void printTime();
}
