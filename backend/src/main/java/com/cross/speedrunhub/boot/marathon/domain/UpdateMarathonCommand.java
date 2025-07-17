package com.cross.speedrunhub.boot.marathon.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdateMarathonCommand {

    private Integer id;
    private String name;
    private String slug;
    private String description;
    private String startDate;
}
