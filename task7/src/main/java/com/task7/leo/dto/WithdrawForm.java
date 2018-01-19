package com.task7.leo.dto;

import com.task7.leo.validation.BuyFundCheck;
import com.task7.leo.validation.WithdrawCheck;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@WithdrawCheck
public class WithdrawForm {

    private double amount;
}
