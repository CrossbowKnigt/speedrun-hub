package com.cross.speedrunhub.marathon.infrastructure.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PutMarathonBodyDTO {

    private String name;
    private String slug;
    private String description;
    private String startDate;
}
