package com.example.demo.model.gym;

import com.example.demo.model.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.time.Duration;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "classes")
public class GymClass extends BaseEntity {
    private String className;
    private String description;
    private Double Price;
    private Duration duration;
    private Integer maxParticipants;
    private String instructor;
}
