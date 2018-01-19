package com.task7.leo.validation.Imp;

import com.task7.leo.domain.Fund;
import com.task7.leo.dto.BuyForm;
import com.task7.leo.dto.FundCreateForm;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.validation.BuyFundCheck;
import com.task7.leo.validation.CreateFundCheck;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BuyFundCheckImpl implements ConstraintValidator<BuyFundCheck, Object> {

    private final FundRepository fundRepository;

    @Autowired
    public BuyFundCheckImpl(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }


    @Override
    public void initialize(BuyFundCheck buyFundCheck) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        BuyForm buyForm = (BuyForm) o;

        // fund exists
        if (fundRepository.findByFundSymbol(buyForm.getFundSymbol()) == null){
            return false;
        }

        // amount limit
        if (buyForm.getAmount() <= 0) {
            return false;
        }

        // amount lower than balance
        // amount higher than threshold

        return true;
    }
}
