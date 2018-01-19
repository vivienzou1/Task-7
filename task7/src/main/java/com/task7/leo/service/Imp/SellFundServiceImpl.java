package com.task7.leo.service.Imp;

import com.task7.leo.domain.Fund;
import com.task7.leo.domain.Sell;
import com.task7.leo.domain.User;
import com.task7.leo.dto.SellForm;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.repositories.SellRepository;
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
    private final SellRepository sellRepository;

    @Autowired
    public SellFundServiceImpl(UserRepository userRepository, FundRepository fundRepository, SellRepository sellRepository) {
        this.userRepository = userRepository;
        this.fundRepository = fundRepository;
        this.sellRepository = sellRepository;
    }

    @Override
    public void sellFund(SellForm sellForm, String username) {
        User user = userRepository.findByUsername(username);
        Fund fund = fundRepository.findByFundSymbol(sellForm.getFundSymbol());
        Sell sell = new Sell(user, fund, sellForm.getShare());
        sellRepository.save(sell);
    }
}
