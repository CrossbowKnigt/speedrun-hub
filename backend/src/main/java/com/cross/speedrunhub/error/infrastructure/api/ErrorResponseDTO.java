package com.cross.speedrunhub.error.infrastructure.api;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ErrorResponseDTO {

    private Integer status;
    private String message;
}
