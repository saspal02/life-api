package dev.saswat.lifeapi.github.entity;

import dev.saswat.lifeapi.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "github_activity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GitHubActivity extends BaseEntity {

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String repository;

    private String description;

    @Column(nullable = false)
    private Instant occurredAt;

    private String url;

    private String actor;
}
