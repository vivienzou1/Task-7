package com.task7.leo.service;


import com.task7.leo.domain.Transaction;
import com.task7.leo.dto.TransitionDayForm;

import java.util.Date;

public interface TransitionDayService {

    TransitionDayForm getForm();
    void updatePrice(TransitionDayForm form);
    void updateLastId(long id);
    void transitionDay();
    void buy(Transaction transaction);
    void sell(Transaction transaction);
    void deposit(Transaction transaction);
    void withdraw(Transaction transaction);
}
