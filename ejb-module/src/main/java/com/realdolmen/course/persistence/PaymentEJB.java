package com.realdolmen.course.persistence;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by RDEAX37 on 14/09/2015.
 */
@Stateless
@LocalBean
public class PaymentEJB implements PaymentEJBRemote {

    @PersistenceContext (name = "myPersistenceContext")
    private EntityManager em;

    @Override
    @Asynchronous
    public Future<String> payByCreditCard() {
       return new AsyncResult<String>("Payed");
    }
}
