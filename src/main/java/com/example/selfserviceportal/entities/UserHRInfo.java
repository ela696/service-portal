package com.example.selfserviceportal.entities;


import com.example.selfserviceportal.entities.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_hr_info")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserHRInfo extends AbstractEntity {

    private String cin;

    private Double numberOfHoursOff = 0d;

    private LocalDate startDate;

    private LocalDate endDate;

    private double note;

    private String managerId;

    private String userId;

    private Double netSalary;

    private Double baseSalary;

    private Integer cnssNumber;

}
