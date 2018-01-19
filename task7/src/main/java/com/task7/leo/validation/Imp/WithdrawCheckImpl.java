package com.task7.leo.validation.Imp;

import com.task7.leo.dto.BuyForm;
import com.task7.leo.dto.WithdrawForm;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.validation.BuyFundCheck;
import com.task7.leo.validation.WithdrawCheck;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WithdrawCheckImpl implements ConstraintValidator<WithdrawCheck, Object> {

    public WithdrawCheckImpl() {}

    @Override
    public void initialize(WithdrawCheck withdrawCheck) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        WithdrawForm withdrawForm = (WithdrawForm) o;

        // amount limit
        if (withdrawForm.getAmount() <= 0) {
            return false;
        }

        // amount lower than balance
        return true;
    }
}
