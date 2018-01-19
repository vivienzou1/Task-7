package com.task7.leo.dto;

import com.task7.leo.validation.DuplicatedCheck;
import com.task7.leo.validation.ParameterCheck;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
public class TransitionForm {

    //@NotBlank(message = "confirm password can not be empty")
    private int fundSymbol;
}
