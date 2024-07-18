package com.example.selfserviceportal.controllers.impl;

import com.example.selfserviceportal.controllers.interfaces.ISelfServicePortalController;
import com.example.selfserviceportal.dtos.BenefitDto;
import com.example.selfserviceportal.dtos.BenefitRequestDto;
import com.example.selfserviceportal.dtos.DayOffRequestDto;
import com.example.selfserviceportal.dtos.UserHrInfoDto;
import com.example.selfserviceportal.services.useCases.IBenefitRequestService;
import com.example.selfserviceportal.services.useCases.IBenefitServices;
import com.example.selfserviceportal.services.useCases.IRequestDayOffService;
import com.example.selfserviceportal.services.useCases.IUserHrInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SelfServicePortalController implements ISelfServicePortalController {

    private final IRequestDayOffService requestDayOffService;
    private final IUserHrInfoService userHrInfoService;
    private final IBenefitServices benefitService;
    private final IBenefitRequestService benefitRequestService;

    @Override
    public ResponseEntity<DayOffRequestDto> sendRequest(DayOffRequestDto dayOffRequestDto) {
        return new ResponseEntity<>(requestDayOffService.createDayOffRequest(dayOffRequestDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<DayOffRequestDto>> getRequestByUserId(String userId) {
        return new ResponseEntity<>(requestDayOffService.getAllRequestDayOffServiceByUserId(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteRequestById(Long id) {
        requestDayOffService.deleteDayOffServiceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<DayOffRequestDto> updateRequest(DayOffRequestDto dayOffRequestDto) {
        return new ResponseEntity<>(requestDayOffService.updateDayOffService(dayOffRequestDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserHrInfoDto> saveUserHrInfo(UserHrInfoDto userHrInfoDto) {
        return ResponseEntity.ok(userHrInfoService.createHrInfo(userHrInfoDto));
    }

    @Override
    public ResponseEntity<UserHrInfoDto> getUserHrInfoByUserId(String userId) {
        return ResponseEntity.ok(userHrInfoService.getUserInfoByUserId(userId));
    }

    @Override
    public ResponseEntity<List<UserHrInfoDto>> getUserHrInfosByUsersIds(List<String> usersIds) {
        return ResponseEntity.ok(userHrInfoService.getUsersInfosIn(usersIds));
    }

    @Override
    public ResponseEntity<List<BenefitDto>> getBenefits() {
        return ResponseEntity.ok(benefitService.getAllBenefits());
    }

    @Override
    public ResponseEntity<BenefitDto> saveBenefit(BenefitDto benefitDto) {
        return new ResponseEntity<>(benefitService.create(benefitDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BenefitDto> updateBenefit(BenefitDto benefitDto) {
        return ResponseEntity.ok(benefitService.update(benefitDto));
    }

    @Override
    public ResponseEntity<Void> delete(Long benefitId) {
        benefitService.delete(benefitId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<BenefitRequestDto>> getBenefitRequests() {
        return ResponseEntity.ok(benefitRequestService.getAllBenefitRequests());
    }

    @Override
    public ResponseEntity<List<BenefitRequestDto>> getBenefitRequestsByEmployeeId(String employeeId) {
        return ResponseEntity.ok(benefitRequestService.getAllBenefitRequestsByEmployeeId(employeeId));
    }

    @Override
    public ResponseEntity<List<BenefitRequestDto>> getBenefitRequestsByManagerId(String managerId) {
        return ResponseEntity.ok(benefitRequestService.getAllBenefitRequestsByManagerId(managerId));
    }

    @Override
    public ResponseEntity<BenefitRequestDto> saveBenefitRequest(BenefitRequestDto benefitRequestDto) {
        return new ResponseEntity<>(benefitRequestService.create(benefitRequestDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteBenefitRequest(Long benefitRequestId) {
        benefitRequestService.deleteBenefitRequest(benefitRequestId);
        return ResponseEntity.noContent().build();
    }
}
