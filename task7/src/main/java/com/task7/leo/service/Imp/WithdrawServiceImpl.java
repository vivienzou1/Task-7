package com.task7.leo.service.Imp;


import com.task7.leo.domain.Transaction;
import com.task7.leo.domain.User;
import com.task7.leo.dto.WithdrawForm;
import com.task7.leo.repositories.TransactionRepository;
import com.task7.leo.repositories.UserRepository;
import com.task7.leo.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class WithdrawServiceImpl implements WithdrawService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public WithdrawServiceImpl(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void withdraw(WithdrawForm withdrawForm, String username) {
        User user = userRepository.findByUsername(username);
        Transaction transaction = new Transaction(user, null, withdrawForm.getAmount(), 0, "withdraw");
        transactionRepository.save(transaction);
    }
}
