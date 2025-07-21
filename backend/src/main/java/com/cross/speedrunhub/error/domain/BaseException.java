package com.cross.speedrunhub.error.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {

    private final String message;

    public BaseException(String message) {
        super(message);
        this.message = message;
    }
}
