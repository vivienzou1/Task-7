package com.task7.leo.validation;

import com.task7.leo.validation.Imp.TransitionDayCheckImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TransitionDayCheckImpl.class)
@Documented
public @interface TransitionDayCheck {

    String message() default "fund doesn't exist or price invalid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
