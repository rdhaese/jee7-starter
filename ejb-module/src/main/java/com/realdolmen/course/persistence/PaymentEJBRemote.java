package com.realdolmen.course.persistence;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.concurrent.Future;

/**
 * Created by RDEAX37 on 14/09/2015.
 */

@Remote
public interface PaymentEJBRemote extends Serializable{

    Future<String> payByCreditCard();
}
