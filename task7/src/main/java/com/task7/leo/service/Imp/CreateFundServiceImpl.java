package com.task7.leo.service.Imp;

import com.task7.leo.domain.Fund;
import com.task7.leo.dto.FundCreateForm;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.service.CreateFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CreateFundServiceImpl implements CreateFundService {

    private final FundRepository fundRepository;

    @Autowired
    public CreateFundServiceImpl(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }

    @Override
    public void createFund(FundCreateForm fundCreateForm) {
        Fund fund = new Fund(fundCreateForm);
        fund.setFundName(fundCreateForm.getFundName());
        fund.setFundSymbol(fundCreateForm.getFundSymbol());
        fund.setPrice(fundCreateForm.getPrice());
        fundRepository.save(fund);
    }



}
