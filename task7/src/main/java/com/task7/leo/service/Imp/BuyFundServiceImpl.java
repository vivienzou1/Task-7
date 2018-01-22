package com.task7.leo.service.Imp;

import com.task7.leo.domain.Customer;
import com.task7.leo.domain.Fund;
import com.task7.leo.domain.Transaction;
import com.task7.leo.domain.User;
import com.task7.leo.dto.BuyForm;
import com.task7.leo.repositories.CustomerRepository;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.repositories.TransactionRepository;
import com.task7.leo.repositories.UserRepository;
import com.task7.leo.service.BuyFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BuyFundServiceImpl implements BuyFundService {

    private final CustomerRepository customerRepository;
    private final FundRepository fundRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public BuyFundServiceImpl(CustomerRepository customerRepository, FundRepository fundRepository, TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.fundRepository = fundRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void buyFund(BuyForm buyForm, String username) {
        Customer customer = customerRepository.findCustomerByUsername(username);
        Fund fund = fundRepository.findByFundSymbol(buyForm.getFundSymbol());
        Transaction transaction = new Transaction(customer, fund, buyForm.getAmount(), 0, "buy");
        transactionRepository.save(transaction);
    }
}
