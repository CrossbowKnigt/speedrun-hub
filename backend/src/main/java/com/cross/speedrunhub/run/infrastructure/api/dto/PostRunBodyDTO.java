package com.cross.speedrunhub.run.infrastructure.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Data
@Getter
@Setter
public class PostRunBodyDTO {
    
    private Long marathonId;
    private Long runnerId;
    private Long gameId;
    private String category;
    private LocalTime estimate;
    private String state;
    private Long orderInMarathon;
    private String setupTime;
}