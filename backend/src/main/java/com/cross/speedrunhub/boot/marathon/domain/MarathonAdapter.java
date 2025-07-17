package com.cross.speedrunhub.boot.marathon.domain;

public interface MarathonAdapter {

    Marathon createMarathon(CreateMarathonCommand command);

    Marathon updateMarathon(UpdateMarathonCommand command);
}
