package com.cross.speedrunhub.run.domain;

import lombok.*;

import java.time.LocalTime;

@Data
@Getter
@Setter
public class CreateRunCommand {
    
    private Long marathonId;
    private Long runnerId;
    private Long gameId;
    private String category;
    private LocalTime estimate;
    private String state;
    private Long orderInMarathon;
    private String setupTime;
}