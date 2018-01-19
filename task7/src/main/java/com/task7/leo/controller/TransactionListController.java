package com.task7.leo.controller;


import com.task7.leo.domain.Transaction;
import com.task7.leo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TransactionListController {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionListController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public String fundList(Model model) {
        List<Transaction> transactions = transactionRepository.findAll();
        model.addAttribute("transactions", transactions);
        return "transaction-list";
    }
}
