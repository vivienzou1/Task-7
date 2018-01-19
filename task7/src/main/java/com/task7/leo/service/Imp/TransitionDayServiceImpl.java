package com.task7.leo.service.Imp;

import com.task7.leo.domain.Fund;
import com.task7.leo.domain.Transaction;
import com.task7.leo.domain.User;
import com.task7.leo.dto.TransitionDayForm;
import com.task7.leo.dto.WithdrawForm;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.repositories.TransactionRepository;
import com.task7.leo.repositories.UserRepository;
import com.task7.leo.service.TransitionDayService;
import com.task7.leo.service.WithdrawService;
import javafx.animation.Transition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TransitionDayServiceImpl implements TransitionDayService {

    private final UserRepository userRepository;
    private final FundRepository fundRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransitionDayServiceImpl(UserRepository userRepository, FundRepository fundRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.fundRepository = fundRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void transitionDay(Date date) {
        // for debug ******************
        long lastId = 0;
        List<Transaction> transactions = transactionRepository.findByIdAfter(lastId);
        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("buy")) {
                buy(transaction, date);
            } else if (transaction.getType().equals("sell")) {
                sell(transaction, date);
            } else if (transaction.getType().equals("deposit")) {
                deposit(transaction, date);
            } else if (transaction.getType().equals("withdraw")) {
                withdraw(transaction, date);
            }
        }
    }

    public void buy(Transaction transaction, Date date) {
        System.out.println("buy");
        transaction.setDate(date);
    }

    public void sell(Transaction transaction, Date date) {
        System.out.println("sell");
        transaction.setDate(date);
    }

    public void deposit(Transaction transaction, Date date) {
        System.out.println("deposit");
        transaction.setDate(date);
    }

    public void withdraw(Transaction transaction, Date date) {
        System.out.println("withdraw");
        transaction.setDate(date);
    }

    public TransitionDayForm getForm() {
        List<Fund> funds = fundRepository.findAll();
        TransitionDayForm transitionDayForm = new TransitionDayForm();
        transitionDayForm.setFunds(funds);
        return transitionDayForm;
    }
}
