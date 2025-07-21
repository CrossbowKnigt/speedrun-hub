package com.cross.speedrunhub.run.domain;

public interface UpdateRunUseCase {
    
    Run execute(UpdateRunCommand command);
}