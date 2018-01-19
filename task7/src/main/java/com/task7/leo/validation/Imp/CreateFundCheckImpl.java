package com.task7.leo.validation.Imp;

import com.task7.leo.domain.Fund;
import com.task7.leo.dto.FundCreateForm;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.validation.CreateFundCheck;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateFundCheckImpl implements ConstraintValidator<CreateFundCheck, Object> {

    private final FundRepository fundRepository;

    @Autowired
    public CreateFundCheckImpl(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }


    @Override
    public void initialize(CreateFundCheck createFundCheck) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        FundCreateForm fundCreateForm = (FundCreateForm) o;

        // duplicate check
        if (fundRepository.findByFundName(fundCreateForm.getFundName()) != null){
            return false;
        }
        if (fundRepository.findByFundSymbol(fundCreateForm.getFundSymbol()) != null){
            return false;
        }

        // parameter check

        // price can't be 0 in case of "division by 0" problem
        if (fundCreateForm.getPrice() <= 0 || fundCreateForm.getPrice() > Fund.PRICE_LIMIT) {
            return false;
        }

        return true;
    }
}
