package com.example.selfserviceportal.dtos;

import com.example.selfserviceportal.entities.Benefit;
import com.example.selfserviceportal.entities.BenefitType;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BenefitRequestDto {
    private Long id;
    private UserDto employee;
    private String motivation;
    private BenefitDto benefitDto;
}
