package dev.saswat.lifeapi.workouts.entity;

import dev.saswat.lifeapi.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.Instant;

@Entity
@Table(name = "workouts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Workout extends BaseEntity {

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Instant performedAt;

    private Duration duration;

    @Column(name = "calories_burned")
    private Integer caloriesBurned;

    private String notes;
}
