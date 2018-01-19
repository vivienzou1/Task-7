package com.task7.leo.validation;

import com.task7.leo.validation.Imp.BuyFundCheckImpl;
import com.task7.leo.validation.Imp.CreateFundCheckImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BuyFundCheckImpl.class)
@Documented
public @interface BuyFundCheck {

    String message() default "fund name or symbol doesn't exit or amount invalid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
