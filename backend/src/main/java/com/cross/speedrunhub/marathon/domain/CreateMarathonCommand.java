package com.cross.speedrunhub.marathon.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateMarathonCommand {

    private String name;
    private String slug;
    private String description;
    private String startDate;
}
