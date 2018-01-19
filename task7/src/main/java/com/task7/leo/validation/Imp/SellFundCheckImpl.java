package com.task7.leo.validation.Imp;

import com.task7.leo.dto.BuyForm;
import com.task7.leo.dto.SellForm;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.validation.BuyFundCheck;
import com.task7.leo.validation.SellFundCheck;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SellFundCheckImpl implements ConstraintValidator<SellFundCheck, Object> {

    private final FundRepository fundRepository;

    @Autowired
    public SellFundCheckImpl(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }


    @Override
    public void initialize(SellFundCheck sellFundCheck) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        SellForm sellForm = (SellForm) o;

        // fund exists
        if (fundRepository.findByFundSymbol(sellForm.getFundSymbol()) == null){
            return false;
        }

        // share limit
        if (sellForm.getShare() <= 0) {
            return false;
        }

        // share lower than owned share

        return true;
    }
}
