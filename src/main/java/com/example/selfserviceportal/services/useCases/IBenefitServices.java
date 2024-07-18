package com.example.selfserviceportal.services.useCases;

import com.example.selfserviceportal.dtos.BenefitDto;

import java.util.List;

public interface IBenefitServices {

    List<BenefitDto> getAllBenefits();

    BenefitDto update(BenefitDto benefitDto);

    void delete(Long id);


    BenefitDto create(BenefitDto benefitDto);
}
