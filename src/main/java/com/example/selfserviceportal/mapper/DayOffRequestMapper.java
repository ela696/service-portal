package com.example.selfserviceportal.mapper;


import com.example.selfserviceportal.clients.UserManagementClient;
import com.example.selfserviceportal.dtos.DayOffRequestDto;
import com.example.selfserviceportal.entities.DayoffRequest;

public class DayOffRequestMapper {

    private DayOffRequestMapper(){

    }
    public static DayOffRequestDto toDto(DayoffRequest dayoffRequest, UserManagementClient userManagementClient) {
        return DayOffRequestDto.builder().id(dayoffRequest.getId())
                .userDto(userManagementClient.toDto(dayoffRequest.getEmployeeId()))
                .status(dayoffRequest.getStatus())
                .reason(dayoffRequest.getReason())
                .startDate(dayoffRequest.getStartDate())
                .endDate(dayoffRequest.getEndDate())
                .daysoffType(dayoffRequest.getDaysoffType()).build();
    }


    public static DayoffRequest toEntity(DayOffRequestDto dayOffRequestDto) {
        DayoffRequest dayoffRequest = DayoffRequest.builder()
                .employeeId(dayOffRequestDto.getUserDto().getUserId())
                .reason(dayOffRequestDto.getReason())
                .startDate(dayOffRequestDto.getStartDate())
                .endDate(dayOffRequestDto.getEndDate())
                .status(dayOffRequestDto.getStatus())
                .daysoffType(dayOffRequestDto.getDaysoffType()).build();
        dayoffRequest.setId(dayOffRequestDto.getId());
        return dayoffRequest;
    }
}
