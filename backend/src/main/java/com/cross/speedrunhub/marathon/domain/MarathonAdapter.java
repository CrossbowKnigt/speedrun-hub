package com.cross.speedrunhub.marathon.domain;

public interface MarathonAdapter {

    Marathon createMarathon(CreateMarathonCommand command);

    Marathon updateMarathon(UpdateMarathonCommand command);
}
