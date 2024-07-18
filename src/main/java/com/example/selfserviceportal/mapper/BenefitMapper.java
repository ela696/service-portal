package com.example.selfserviceportal.mapper;


import com.example.selfserviceportal.dtos.BenefitDto;
import com.example.selfserviceportal.entities.Benefit;

public class BenefitMapper {

    private BenefitMapper(){

    }
    public static BenefitDto toDto(Benefit benefit) {
        return BenefitDto.builder().id(benefit.getId())
                .backgroundImageUri(benefit.getBackgroundImageUri())
                .name(benefit.getName())
                .type(benefit.getType())
                .description(benefit.getDescription())
                .build();
    }


    public static Benefit toEntity(BenefitDto benefitDto) {
        Benefit benefit = Benefit.builder()
                .name(benefitDto.getName())
                .type(benefitDto.getType())
                .description(benefitDto.getDescription())
                .backgroundImageUri(benefitDto.getBackgroundImageUri())
                .build();
        benefit.setId(benefitDto.getId());
        return benefit;
    }
}
