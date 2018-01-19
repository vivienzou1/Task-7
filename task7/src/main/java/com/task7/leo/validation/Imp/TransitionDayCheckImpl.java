package com.task7.leo.validation.Imp;

import com.task7.leo.domain.Fund;
import com.task7.leo.dto.TransitionDayForm;
import com.task7.leo.dto.WithdrawForm;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.validation.TransitionDayCheck;
import com.task7.leo.validation.WithdrawCheck;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TransitionDayCheckImpl implements ConstraintValidator<TransitionDayCheck, Object> {

    private final FundRepository fundRepository;

    @Autowired
    public TransitionDayCheckImpl(FundRepository fundRepository) { this.fundRepository = fundRepository; }

    @Override
    public void initialize(TransitionDayCheck transitionDayCheck) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        TransitionDayForm transitionDayForm = (TransitionDayForm) o;

        for (Fund fund : transitionDayForm.getFunds()) {

            // fund exists
            if (fundRepository.findByFundSymbol(fund.getFundSymbol()) == null) {
                return false;
            }

            // price valid
            if (fund.getPrice() <= 0) {
                return false;
            }

            // upper price limit
        }

        return true;
    }
}
