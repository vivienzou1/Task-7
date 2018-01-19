package com.task7.leo.service.Imp;

import com.task7.leo.domain.Transaction;
import com.task7.leo.domain.User;
import com.task7.leo.dto.DepositForm;
import com.task7.leo.repositories.TransactionRepository;
import com.task7.leo.repositories.UserRepository;
import com.task7.leo.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DepositServiceImpl implements DepositService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public DepositServiceImpl(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void deposit(DepositForm depositForm) {
        User user = userRepository.findByUsername(depositForm.getUsername());
        Transaction transaction = new Transaction(user, null, depositForm.getAmount(), 0, "deposit");
        transactionRepository.save(transaction);
    }
}
