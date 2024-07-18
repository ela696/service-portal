package com.example.selfserviceportal.services.useCases;

import com.example.selfserviceportal.dtos.BenefitRequestDto;

import java.util.List;

public interface IBenefitRequestService {

    List<BenefitRequestDto> getAllBenefitRequests();


    void deleteBenefitRequest(Long id);


    BenefitRequestDto create(BenefitRequestDto benefitRequestDto);
    List<BenefitRequestDto> getAllBenefitRequestsByEmployeeId(String employeeId);
    List<BenefitRequestDto> getAllBenefitRequestsByManagerId(String employeeId);

}
