package com.cross.speedrunhub.boot.marathon.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Marathon {

    private Integer id;
    private String name;
    private String slug;
    private String description;
    private String startDate;
    private String endDate;
}
