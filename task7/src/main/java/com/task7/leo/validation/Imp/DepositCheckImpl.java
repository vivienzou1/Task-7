package com.task7.leo.validation.Imp;

import com.task7.leo.dto.DepositForm;
import com.task7.leo.dto.WithdrawForm;
import com.task7.leo.repositories.CustomerRepository;
import com.task7.leo.repositories.FundRepository;
import com.task7.leo.repositories.UserRepository;
import com.task7.leo.validation.DepositCheck;
import com.task7.leo.validation.WithdrawCheck;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepositCheckImpl implements ConstraintValidator<DepositCheck, Object> {

    private final CustomerRepository customerRepository;

    @Autowired
    public DepositCheckImpl(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    @Override
    public void initialize(DepositCheck depositCheck) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        DepositForm depositForm = (DepositForm) o;

        // customer exist
        if (customerRepository.findCustomerByUsername(depositForm.getUsername()) == null) {
            return false;
        }

        // amount limit
        if (depositForm.getAmount() <= 0) {
            return false;
        }

        // amount lower than balance
        return true;
    }
}
