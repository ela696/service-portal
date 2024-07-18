package com.example.selfserviceportal.dtos;

import com.example.selfserviceportal.entities.DaysOffStatus;
import com.example.selfserviceportal.entities.DaysOffType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class DayOffRequestDto {
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;


    private DaysOffType daysoffType;

    private DaysOffStatus status;

    private String reason;

    private UserDto userDto;


}
