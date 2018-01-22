package com.task7.leo.service.Imp;

import com.task7.leo.domain.Customer;
import com.task7.leo.domain.Fund;
import com.task7.leo.domain.Transaction;
import com.task7.leo.domain.User;
import com.task7.leo.dto.SellForm;
import com.task7.leo.repositories.CustomerRepository;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.repositories.TransactionRepository;
import com.task7.leo.repositories.UserRepository;
import com.task7.leo.service.SellFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SellFundServiceImpl implements SellFundService {

    private final CustomerRepository customerRepository;
    private final FundRepository fundRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public SellFundServiceImpl(CustomerRepository customerRepository, FundRepository fundRepository, TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.fundRepository = fundRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void sellFund(SellForm sellForm, String username) {
        Customer customer = customerRepository.findCustomerByUsername(username);
        Fund fund = fundRepository.findByFundSymbol(sellForm.getFundSymbol());
        Transaction transaction = new Transaction(customer, fund, 0, sellForm.getShare(), "sell");
        transactionRepository.save(transaction);
    }
}
