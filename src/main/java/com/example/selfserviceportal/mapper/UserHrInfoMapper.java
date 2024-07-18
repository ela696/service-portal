package com.example.selfserviceportal.mapper;

import com.example.selfserviceportal.clients.UserManagementClient;
import com.example.selfserviceportal.dtos.UserHrInfoDto;
import com.example.selfserviceportal.entities.UserHRInfo;

public class UserHrInfoMapper {
    private UserHrInfoMapper(){
    }

    public static UserHrInfoDto toDto(UserHRInfo userHRInfo, UserManagementClient userManagementClient) {
         return UserHrInfoDto.builder()
                .userDto(userManagementClient.toDto(userHRInfo.getUserId()))
                 .manager(userManagementClient.toDto(userHRInfo.getManagerId()))
                 .cin(userHRInfo.getCin())
                 .cnssNumber(userHRInfo.getCnssNumber())
                 .baseSalary(userHRInfo.getBaseSalary())
                 .netSalary(userHRInfo.getNetSalary())
                 .id(userHRInfo.getId())
                .startDate(userHRInfo.getStartDate())
                .endDate(userHRInfo.getEndDate())
                .note(userHRInfo.getNote())
                 .numberOfHoursOff(userHRInfo.getNumberOfHoursOff()).build();
    }


    public static UserHRInfo toEntity(UserHrInfoDto userHrInfoDto) {
        UserHRInfo userHRInfo = UserHRInfo.builder()
                .userId(userHrInfoDto.getUserDto().getUserId())
                .cin(userHrInfoDto.getCin())
                .managerId(userHrInfoDto.getManager().getUserId())
                .netSalary(userHrInfoDto.getNetSalary())
                .baseSalary(userHrInfoDto.getBaseSalary())
                .cnssNumber(userHrInfoDto.getCnssNumber())
                .note(userHrInfoDto.getNote())
                .startDate(userHrInfoDto.getStartDate())
                .endDate(userHrInfoDto.getEndDate())
                .numberOfHoursOff(userHrInfoDto.getNumberOfHoursOff()).build();
        userHRInfo.setId(userHRInfo.getId());
        return userHRInfo;
    }
}
