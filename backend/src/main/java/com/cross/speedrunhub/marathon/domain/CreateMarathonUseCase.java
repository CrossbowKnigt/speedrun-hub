package com.cross.speedrunhub.marathon.domain;

public interface CreateMarathonUseCase {

    Marathon createMarathon(CreateMarathonCommand createMarathonCommand);
}
