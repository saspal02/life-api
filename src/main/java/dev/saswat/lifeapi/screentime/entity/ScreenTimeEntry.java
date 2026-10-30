package dev.saswat.lifeapi.screentime.entity;

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
@Table(name = "screen_time")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ScreenTimeEntry extends BaseEntity {

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private Instant recordedAt;

    @Column(nullable = false)
    private Duration duration;

    private String category;

    private String notes;
}
