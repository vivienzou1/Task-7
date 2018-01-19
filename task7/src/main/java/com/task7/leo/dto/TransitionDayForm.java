package com.task7.leo.dto;


import com.task7.leo.domain.Fund;
import com.task7.leo.validation.TransitionDayCheck;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@TransitionDayCheck
public class TransitionDayForm {

    private List<Fund> funds;
    private Date date;
}
