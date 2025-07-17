package com.cross.speedrunhub.boot.marathon.domain;

public interface CreateMarathonUseCase {

    Marathon createMarathon(CreateMarathonCommand createMarathonCommand);
}
