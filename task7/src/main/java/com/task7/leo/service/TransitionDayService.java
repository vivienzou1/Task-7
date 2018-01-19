package com.task7.leo.service;


import com.task7.leo.domain.Transaction;
import com.task7.leo.dto.TransitionDayForm;

import java.util.Date;

public interface TransitionDayService {

    TransitionDayForm getForm();
    void transitionDay(Date date);
    void buy(Transaction transaction, Date date);
    void sell(Transaction transaction, Date date);
    void deposit(Transaction transaction, Date date);
    void withdraw(Transaction transaction, Date date);
}
