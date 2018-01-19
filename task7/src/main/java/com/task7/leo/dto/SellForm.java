package com.task7.leo.dto;

import com.task7.leo.validation.DuplicatedCheck;
import com.task7.leo.validation.ParameterCheck;
import com.task7.leo.validation.SellFundCheck;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SellFundCheck
public class SellForm extends TransitionForm {

    private double share;
}
