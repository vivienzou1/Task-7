package com.task7.leo.validation;


import com.task7.leo.validation.Imp.DepositCheckImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DepositCheckImpl.class)
@Documented
public @interface DepositCheck {

    String message() default "amount invalid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
