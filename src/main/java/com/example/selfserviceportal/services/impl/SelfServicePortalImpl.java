package com.example.selfserviceportal.services.impl;

import com.example.selfserviceportal.clients.UserManagementClient;
import com.example.selfserviceportal.dtos.BenefitDto;
import com.example.selfserviceportal.dtos.BenefitRequestDto;
import com.example.selfserviceportal.dtos.DayOffRequestDto;
import com.example.selfserviceportal.dtos.UserHrInfoDto;
import com.example.selfserviceportal.entities.Benefit;
import com.example.selfserviceportal.entities.BenefitRequest;
import com.example.selfserviceportal.entities.DayoffRequest;
import com.example.selfserviceportal.entities.UserHRInfo;
import com.example.selfserviceportal.exceptions.EntityNotFoundException;
import com.example.selfserviceportal.handlers.ErrorCodes;
import com.example.selfserviceportal.mapper.BenefitMapper;
import com.example.selfserviceportal.mapper.BenefitRequestMapper;
import com.example.selfserviceportal.mapper.DayOffRequestMapper;
import com.example.selfserviceportal.mapper.UserHrInfoMapper;
import com.example.selfserviceportal.repository.BenefitRepository;
import com.example.selfserviceportal.repository.BenefitRequestRepository;
import com.example.selfserviceportal.repository.DayOffRequestRepository;
import com.example.selfserviceportal.repository.UserHrInfoRepository;
import com.example.selfserviceportal.services.useCases.IBenefitRequestService;
import com.example.selfserviceportal.services.useCases.IBenefitServices;
import com.example.selfserviceportal.services.useCases.IRequestDayOffService;
import com.example.selfserviceportal.services.useCases.IUserHrInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SelfServicePortalImpl implements IRequestDayOffService, IUserHrInfoService, IBenefitServices, IBenefitRequestService {

    private final DayOffRequestRepository dayOffRequestRepository;
    private final UserHrInfoRepository userHrInfoRepository;
    private final BenefitRepository benefitRepository;
    private final BenefitRequestRepository benefitRequestRepository;
    private final UserManagementClient userManagementClient;

    @Override
    public List<DayOffRequestDto> getAllRequestDayOffServiceByUserId(String userId) {
        return dayOffRequestRepository.findAllByEmployeeId(userId).stream()
                .map(d -> DayOffRequestMapper.toDto(d, userManagementClient)).toList();
    }

    @Override
    public DayOffRequestDto updateDayOffService(DayOffRequestDto dayOffRequestDto) {

        DayoffRequest request= dayOffRequestRepository.findById(dayOffRequestDto.getId()).orElseThrow(()->
                new EntityNotFoundException("Id with this day off request is not found", ErrorCodes.ENTITY_NOT_FOUND));

        if (Objects.nonNull(dayOffRequestDto.getDaysoffType())) {
            request.setDaysoffType(
                    dayOffRequestDto.getDaysoffType());
        }

        if (Objects.nonNull(
                dayOffRequestDto.getReason())
                && !"".equalsIgnoreCase(
                dayOffRequestDto.getReason())) {
            request.setReason(
                    dayOffRequestDto.getReason());
        }

        if (Objects.nonNull(dayOffRequestDto.getStartDate())) {
            request.setStartDate(
                    dayOffRequestDto.getStartDate());
        }

        if (Objects.nonNull(dayOffRequestDto.getEndDate())) {
            request.setEndDate(
                    dayOffRequestDto.getEndDate());
        }

        if (Objects.nonNull(dayOffRequestDto.getStatus())) {
            request.setStatus(
                    dayOffRequestDto.getStatus());
        }

        return DayOffRequestMapper.toDto(dayOffRequestRepository.save(request), userManagementClient);
    }

    @Override
    public void deleteDayOffServiceById(Long id) {
        DayoffRequest dayoffRequest1 = dayOffRequestRepository.findById(id).orElse(null);
        if(dayoffRequest1 == null)
            throw new EntityNotFoundException("there is no dayOffRequest with this id"
            ,ErrorCodes.ENTITY_NOT_FOUND);
      dayOffRequestRepository.deleteById(id);
      DayoffRequest dayoffRequest= dayOffRequestRepository.findById(id).orElse(null);
      if(dayoffRequest != null){
          throw new EntityNotFoundException("DayoffRequest not deleted id is not found",
                  ErrorCodes.ENTITY_NOT_FOUND);
      }
    }

    @Override
    public DayOffRequestDto createDayOffRequest(DayOffRequestDto dayOffRequestDto) {
        DayoffRequest dayoffRequest = DayOffRequestMapper.toEntity(dayOffRequestDto);
        dayOffRequestRepository.saveAndFlush(dayoffRequest);
        return DayOffRequestMapper.toDto(dayoffRequest, userManagementClient);
    }


    @Scheduled(fixedDelay = 24 * 60 * 60 * 1000)
    void calculateDayOffRemainingDays() {
        userHrInfoRepository.findAll().forEach(e -> {
            e.setNumberOfHoursOff(e.getNumberOfHoursOff() + 1.5);
            userHrInfoRepository.save(e);
        });
    }

    @Override
    public UserHrInfoDto createHrInfo(UserHrInfoDto userHrInfoDto) {
        UserHRInfo userHRInfo = UserHrInfoMapper.toEntity(userHrInfoDto);
        userHrInfoRepository.saveAndFlush(userHRInfo);
        return UserHrInfoMapper.toDto(userHRInfo, userManagementClient);
    }

    @Override
    public UserHrInfoDto getUserInfoByUserId(String userId) {
        UserHRInfo userHRInfo = userHrInfoRepository.findByUserId(userId).orElseThrow(()-> new EntityNotFoundException("user with this id is not found",ErrorCodes.ENTITY_NOT_FOUND));
        return UserHrInfoMapper.toDto(userHRInfo, userManagementClient);
    }

    @Override
    public List<UserHrInfoDto> getUsersInfosIn(List<String> usersIds) {
        return userHrInfoRepository.findByUserIdIn(usersIds)
                .stream().map(u -> UserHrInfoMapper.toDto(u, userManagementClient)).toList();
    }

    @Override
    public List<BenefitDto> getAllBenefits() {
        return benefitRepository.findAll().stream().map(BenefitMapper::toDto).toList();
    }

    @Override
    public BenefitDto update(BenefitDto benefitDto) {
        Benefit benefit= benefitRepository.findById(benefitDto.getId()).orElseThrow(()->
                new EntityNotFoundException("Id with this day off benefit is not found", ErrorCodes.ENTITY_NOT_FOUND));

        if (Objects.nonNull(benefitDto.getType())) {
            benefit.setType(
                    benefitDto.getType());
        }

        if (Objects.nonNull(
                benefitDto.getName())
                && !"".equalsIgnoreCase(
                benefitDto.getName())) {
            benefit.setName(
                    benefitDto.getName());
        }

        if (Objects.nonNull(
                benefitDto.getDescription())
                && !"".equalsIgnoreCase(
                benefitDto.getDescription())) {
            benefit.setDescription(
                    benefitDto.getDescription());
        }

        if (Objects.nonNull(
                benefitDto.getBackgroundImageUri())
                && !"".equalsIgnoreCase(
                benefitDto.getBackgroundImageUri())) {
            benefit.setBackgroundImageUri(
                    benefitDto.getBackgroundImageUri());
        }

        if (Objects.nonNull(benefitDto.getId())) {
            benefit.setId(
                    benefitDto.getId());
        }

        return BenefitMapper.toDto(benefitRepository.save(benefit));
    }

    @Override
    public void delete(Long id) {
        Benefit benefit = benefitRepository.findById(id).orElse(null);
        if(benefit == null)
            throw new EntityNotFoundException("there is no benefit with this id"
                    ,ErrorCodes.ENTITY_NOT_FOUND);
        benefitRepository.deleteById(id);
        Benefit benefit1= benefitRepository.findById(id).orElse(null);
        if(benefit1 != null){
            throw new EntityNotFoundException("DayoffRequest not deleted id is not found",
                    ErrorCodes.ENTITY_NOT_FOUND);
        }
    }

    @Override
    public BenefitDto create(BenefitDto benefitDto) {
        return BenefitMapper.toDto(benefitRepository.save(BenefitMapper.toEntity(benefitDto)));
    }

    @Override
    public List<BenefitRequestDto> getAllBenefitRequests() {
        return benefitRequestRepository.findAll().stream().map(b -> BenefitRequestMapper.toDto(b, userManagementClient)).toList();
    }

    @Override
    public List<BenefitRequestDto> getAllBenefitRequestsByEmployeeId(String employeeId) {
        return benefitRequestRepository.findAllByEmployeeId(employeeId).stream().map(b -> BenefitRequestMapper.toDto(b, userManagementClient)).toList();
    }

    @Override
    public List<BenefitRequestDto> getAllBenefitRequestsByManagerId(String managerId) {
        return benefitRequestRepository.findAllByManagerId(managerId).stream().map(b-> BenefitRequestMapper.toDto(b,userManagementClient)).toList();
    }

    @Override
    public void deleteBenefitRequest(Long id) {
        benefitRequestRepository.deleteById(id);
    }

    @Override
    public BenefitRequestDto create(BenefitRequestDto benefitRequestDto) {
        BenefitRequest benefitRequest= BenefitRequestMapper.toEntity(benefitRequestDto);
        benefitRequest.setManagerId(getUserInfoByUserId(benefitRequestDto.getEmployee().getUserId()).getManager().getUserId());
        return BenefitRequestMapper.toDto(benefitRequestRepository.save(benefitRequest), userManagementClient);
    }
}
