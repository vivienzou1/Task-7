package com.task7.leo.dto;

import com.task7.leo.validation.CreateFundCheck;
import com.task7.leo.validation.DuplicatedCheck;
import com.task7.leo.validation.ParameterCheck;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@CreateFundCheck
public class FundCreateForm {

    @NotBlank(message = "fund name can not be empty")
    private String fundName;

    //@NotBlank(message = "fund symbol can not be empty")
    private int fundSymbol;

    //@NotBlank(message = "price can not be empty")
    private double price;
}
