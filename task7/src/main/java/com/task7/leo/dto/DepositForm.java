package com.task7.leo.dto;

import com.task7.leo.validation.BuyFundCheck;
import com.task7.leo.validation.DepositCheck;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DepositCheck
public class DepositForm {

    private String username;
    private double amount;
}
