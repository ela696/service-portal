package com.example.selfserviceportal.services.useCases;

import com.example.selfserviceportal.dtos.DayOffRequestDto;

import java.util.List;

public interface IRequestDayOffService {
    List<DayOffRequestDto> getAllRequestDayOffServiceByUserId(String userId);

    DayOffRequestDto updateDayOffService(DayOffRequestDto dayOffRequestDto);

    void deleteDayOffServiceById(Long id);


    DayOffRequestDto createDayOffRequest(DayOffRequestDto dayOffRequestDto);

}
