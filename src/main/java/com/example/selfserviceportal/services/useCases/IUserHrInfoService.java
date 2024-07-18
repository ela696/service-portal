package com.example.selfserviceportal.services.useCases;

import com.example.selfserviceportal.dtos.BenefitRequestDto;
import com.example.selfserviceportal.dtos.UserHrInfoDto;

import java.util.List;

public interface IUserHrInfoService {
    UserHrInfoDto createHrInfo(UserHrInfoDto userHrInfoDto);
    UserHrInfoDto getUserInfoByUserId(String userId);
    List<UserHrInfoDto> getUsersInfosIn(List<String> usersIds);

}
