package com.example.selfserviceportal.dtos;

import com.example.selfserviceportal.entities.BenefitType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BenefitDto {
    private Long id;
    private BenefitType type;
    private String name;
    private String backgroundImageUri;
    private String description;
}
