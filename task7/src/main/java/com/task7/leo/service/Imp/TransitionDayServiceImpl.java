package com.task7.leo.service.Imp;

import com.task7.leo.domain.Fund;
import com.task7.leo.domain.Transaction;
import com.task7.leo.dto.TransitionDayForm;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.repositories.TransactionRepository;
import com.task7.leo.service.TransitionDayService;
import javafx.animation.Transition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TransitionDayServiceImpl implements TransitionDayService {

    private final FundRepository fundRepository;
    private final TransactionRepository transactionRepository;
    private Date date;

    @Autowired
    public TransitionDayServiceImpl(FundRepository fundRepository, TransactionRepository transactionRepository) {
        this.fundRepository = fundRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void transitionDay() {
        // for debug ******************
        long lastId = 0;
        List<Transaction> transactions = transactionRepository.findByIdAfter(lastId);
        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("buy")) {
                buy(transaction);
            } else if (transaction.getType().equals("sell")) {
                sell(transaction);
            } else if (transaction.getType().equals("deposit")) {
                deposit(transaction);
            } else if (transaction.getType().equals("withdraw")) {
                withdraw(transaction);
            }
        }
    }

    public void buy(Transaction transaction) {
        System.out.println("buy");
        System.out.println(date);
        transactionRepository.updateDateById(date, transaction.getId());
        System.out.println("success");
    }

    public void sell(Transaction transaction) {
        System.out.println("sell");
        transactionRepository.updateDateById(date, transaction.getId());
    }

    public void deposit(Transaction transaction) {
        System.out.println("deposit");
        transactionRepository.updateDateById(date, transaction.getId());
    }

    public void withdraw(Transaction transaction) {
        System.out.println("withdraw");
        transactionRepository.updateDateById(date, transaction.getId());
    }

    public TransitionDayForm getForm() {
        List<Fund> funds = fundRepository.findAll();
        TransitionDayForm transitionDayForm = new TransitionDayForm();
        transitionDayForm.setFunds(funds);
        return transitionDayForm;
    }

    public void updatePrice(TransitionDayForm transitionDayForm) {
        for (Fund fund : transitionDayForm.getFunds()) {

            fundRepository.updatePriceBySymbol(fund.getPrice(), fund.getFundSymbol());

        }

        this.date = transitionDayForm.getDate();
    }
}
