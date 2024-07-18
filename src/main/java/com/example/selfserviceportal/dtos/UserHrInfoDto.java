package com.example.selfserviceportal.dtos;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserHrInfoDto {
    private Long id;

    private Double numberOfHoursOff;

    private LocalDate startDate;

    private LocalDate endDate;

    private double note;

    private String cin;

    private UserDto userDto;

    private UserDto manager;

    private Double netSalary;

    private Double baseSalary;

    private Integer cnssNumber;
}
