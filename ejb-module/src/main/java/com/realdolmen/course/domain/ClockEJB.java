package com.realdolmen.course.domain;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.TimerService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalTime;

/**
 * Created by RDEAX37 on 14/09/2015.
 */
@Stateless
@LocalBean
public class ClockEJB implements ClockEJBRemote {
    @Resource
    private TimerService timerService;
    @PersistenceContext(name = "MyPersistenceUnit")
    private EntityManager em;

    @Schedule(second = "0/10", minute = "*", hour = "*", persistent = false)
    public void printTime(){
        System.out.println(LocalTime.now());
    }
}
