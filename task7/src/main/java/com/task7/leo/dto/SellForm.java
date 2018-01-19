package com.task7.leo.dto;


import com.task7.leo.validation.SellFundCheck;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SellFundCheck
public class SellForm {

    private int fundSymbol;
    private double share;
}
