package com.task7.leo.validation;

import com.task7.leo.validation.Imp.SellFundCheckImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SellFundCheckImpl.class)
@Documented
public @interface SellFundCheck {

    String message() default "fund name or symbol doesn't exit or share invalid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
