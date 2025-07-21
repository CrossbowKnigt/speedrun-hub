package com.cross.speedrunhub.run.infrastructure.adapter.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "run")
public class RunJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "marathon_id")
    private Long marathonId;

    @Column(name = "runner_id")
    private Long runnerId;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "category")
    private String category;

    @Column(name = "estimate")
    private LocalTime estimate;

    @Column(name = "state")
    private String state;

    @Column(name = "order_in_marathon")
    private Long orderInMarathon;

    @Column(name = "setup_time")
    private String setupTime;
}