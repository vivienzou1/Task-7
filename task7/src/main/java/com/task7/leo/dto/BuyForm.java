package com.task7.leo.dto;

import com.task7.leo.validation.BuyFundCheck;
import com.task7.leo.validation.DuplicatedCheck;
import com.task7.leo.validation.ParameterCheck;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@BuyFundCheck
public class BuyForm extends TransitionForm {

    private double amount;
}
