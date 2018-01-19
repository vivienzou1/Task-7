package com.task7.leo.service.Imp;

import com.task7.leo.domain.Fund;
import com.task7.leo.domain.Transaction;
import com.task7.leo.domain.User;
import com.task7.leo.dto.SellForm;
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

    private final UserRepository userRepository;
    private final FundRepository fundRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public SellFundServiceImpl(UserRepository userRepository, FundRepository fundRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.fundRepository = fundRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void sellFund(SellForm sellForm, String username) {
        User user = userRepository.findByUsername(username);
        Fund fund = fundRepository.findByFundSymbol(sellForm.getFundSymbol());
        Transaction transaction = new Transaction(user, fund, 0, sellForm.getShare(), "sell");
        transactionRepository.save(transaction);
    }
}
