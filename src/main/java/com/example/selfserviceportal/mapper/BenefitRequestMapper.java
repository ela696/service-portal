package com.example.selfserviceportal.mapper;


import com.example.selfserviceportal.clients.UserManagementClient;
import com.example.selfserviceportal.dtos.BenefitRequestDto;
import com.example.selfserviceportal.entities.BenefitRequest;

public class BenefitRequestMapper {

    private BenefitRequestMapper(){

    }
    public static BenefitRequestDto toDto(BenefitRequest benefitRequest, UserManagementClient userManagementClient) {
        return BenefitRequestDto.builder().id(benefitRequest.getId())
                .employee(userManagementClient.toDto(benefitRequest.getEmployeeId()))
                .motivation(benefitRequest.getMotivation())
                .benefitDto(BenefitMapper.toDto(benefitRequest.getBenefit()))
                .build();
    }


    public static BenefitRequest toEntity(BenefitRequestDto benefitRequestDto) {
        BenefitRequest benefitRequest = BenefitRequest.builder()
                .employeeId(benefitRequestDto.getEmployee().getUserId())
                .motivation(benefitRequestDto.getMotivation())
                .benefit(BenefitMapper.toEntity(benefitRequestDto.getBenefitDto()))
                .build();
        benefitRequest.setId(benefitRequestDto.getId());
        return benefitRequest;
    }
}
