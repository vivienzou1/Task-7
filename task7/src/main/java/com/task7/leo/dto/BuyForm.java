package com.task7.leo.dto;


import com.task7.leo.validation.BuyFundCheck;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@BuyFundCheck
public class BuyForm {

    private int fundSymbol;
    private double amount;
}
