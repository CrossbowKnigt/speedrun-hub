package com.cross.speedrunhub.error.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends BaseException {

    public NotFoundException(String message) {
        super(message);
    }
}
