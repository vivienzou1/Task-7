package com.task7.leo.service.Imp;

import com.task7.leo.domain.Customer;
import com.task7.leo.domain.Transaction;
import com.task7.leo.domain.User;
import com.task7.leo.dto.DepositForm;
import com.task7.leo.repositories.CustomerRepository;
import com.task7.leo.repositories.TransactionRepository;
import com.task7.leo.repositories.UserRepository;
import com.task7.leo.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DepositServiceImpl implements DepositService {

    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public DepositServiceImpl(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void deposit(DepositForm depositForm) {
        System.out.println(depositForm.getUsername());
        Customer customer = customerRepository.findCustomerByUsername(depositForm.getUsername());
        System.out.println(customer);
        Transaction transaction = new Transaction(customer, null, depositForm.getAmount(), 0, "deposit");
        transactionRepository.save(transaction);
    }
}
