package com.cross.speedrunhub.marathon.domain;

import java.util.List;

public interface MarathonAdapter {

    Marathon createMarathon(CreateMarathonCommand command);

    Marathon updateMarathon(UpdateMarathonCommand command);

    Marathon getMarathonById(Integer id);

    List<Marathon> getAllMarathons();

    void deleteMarathon(Integer id);
}
