package com.task7.leo.service.Imp;

import com.task7.leo.domain.Buy;
import com.task7.leo.domain.Fund;
import com.task7.leo.domain.User;
import com.task7.leo.dto.BuyForm;
import com.task7.leo.dto.FundCreateForm;
import com.task7.leo.dto.UserRegisterForm;
import com.task7.leo.repositories.BuyRepository;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.repositories.UserRepository;
import com.task7.leo.service.BuyFundService;
import com.task7.leo.service.CreateFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BuyFundServiceImpl implements BuyFundService {

    private final UserRepository userRepository;
    private final FundRepository fundRepository;
    private final BuyRepository buyRepository;

    @Autowired
    public BuyFundServiceImpl(UserRepository userRepository, FundRepository fundRepository, BuyRepository buyRepository) {
        this.userRepository = userRepository;
        this.fundRepository = fundRepository;
        this.buyRepository = buyRepository;
    }

    @Override
    public void buyFund(BuyForm buyForm, String username) {
        User user = userRepository.findByUsername(username);
        Fund fund = fundRepository.findByFundSymbol(buyForm.getFundSymbol());
        Buy buy = new Buy(user, fund, buyForm.getAmount());
        buyRepository.save(buy);
    }
}
