package com.cross.speedrunhub.run.domain;

public interface CreateRunUseCase {
    
    Run execute(CreateRunCommand command);
}