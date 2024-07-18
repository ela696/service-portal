package com.example.selfserviceportal.controllers.interfaces;

import com.example.selfserviceportal.dtos.BenefitDto;
import com.example.selfserviceportal.dtos.BenefitRequestDto;
import com.example.selfserviceportal.dtos.DayOffRequestDto;
import com.example.selfserviceportal.dtos.UserHrInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("self-service")
public interface ISelfServicePortalController {

    @PostMapping(path = "/dayoffrequest")
    ResponseEntity<DayOffRequestDto> sendRequest(@RequestBody DayOffRequestDto dayOffRequestDto);
    @GetMapping(path = "/dayoffrequest/{userId}")
    ResponseEntity<List<DayOffRequestDto>> getRequestByUserId(@PathVariable String userId);
    @DeleteMapping(path = "/dayoffrequest/{id}")
    ResponseEntity<Void> deleteRequestById(@PathVariable Long id);
    @PutMapping(path = "/dayoffrequest")
    ResponseEntity<DayOffRequestDto> updateRequest(@RequestBody DayOffRequestDto dayOffRequestDto);

    @PostMapping("/userhrinfo")
    ResponseEntity<UserHrInfoDto> saveUserHrInfo(@RequestBody UserHrInfoDto userHrInfoDto);

    @GetMapping("/userhrinfo/{userId}")
    ResponseEntity<UserHrInfoDto> getUserHrInfoByUserId(@PathVariable String userId);

    @GetMapping("/getUsersHrInfoInIds")
    ResponseEntity<List<UserHrInfoDto>> getUserHrInfosByUsersIds(@RequestParam List<String> usersIds);

    @GetMapping("/benefit")
    ResponseEntity<List<BenefitDto>> getBenefits();

    @PostMapping(path = "/benefit")
    ResponseEntity<BenefitDto> saveBenefit(@RequestBody BenefitDto benefitDto);

    @PutMapping(path = "/benefit")
    ResponseEntity<BenefitDto> updateBenefit(@RequestBody BenefitDto benefitDto);

    @DeleteMapping(path = "/benefit/{benefitId}")
    ResponseEntity<Void> delete(@PathVariable Long benefitId);


    @GetMapping("/benefitRequest")
    ResponseEntity<List<BenefitRequestDto>> getBenefitRequests();

    @GetMapping("/benefitRequestByEmployee/{employeeId}")
    ResponseEntity<List<BenefitRequestDto>> getBenefitRequestsByEmployeeId(@PathVariable String employeeId);

    @GetMapping("/benefitRequestbyManager/{managerId}")
    ResponseEntity<List<BenefitRequestDto>> getBenefitRequestsByManagerId(@PathVariable String managerId);

    @PostMapping(path = "/benefitRequest")
    ResponseEntity<BenefitRequestDto> saveBenefitRequest(@RequestBody BenefitRequestDto benefitRequestDto);

    @DeleteMapping(path = "/benefit/{benefitRequestId}")
    ResponseEntity<Void> deleteBenefitRequest(@PathVariable Long benefitRequestId);
}
