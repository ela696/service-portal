package com.example.selfserviceportal.entities;


import com.example.selfserviceportal.entities.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "day_off_request")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DayoffRequest extends AbstractEntity {

    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private DaysOffType daysoffType;
    @Enumerated(EnumType.STRING)
    private DaysOffStatus status;
    private String reason;
    private String employeeId;

}
