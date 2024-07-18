package com.example.selfserviceportal.entities;

import com.example.selfserviceportal.entities.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "events")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Events extends AbstractEntity {

    private String name;
    private String description;
    private String userId;
    private String imageUrl;
    private String imageCoverUrl;
    private String usersIds;
}
