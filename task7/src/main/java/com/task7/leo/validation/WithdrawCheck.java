package com.task7.leo.validation;


import com.task7.leo.validation.Imp.WithdrawCheckImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WithdrawCheckImpl.class)
@Documented
public @interface WithdrawCheck {

    String message() default "amount invalid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
