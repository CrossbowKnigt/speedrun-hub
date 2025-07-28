package com.cross.speedrunhub.marathon.domain;

import java.util.List;

public interface GetMarathonUseCase {

    List<Marathon> getAllMarathons();

    Marathon getMarathonById(Integer id);
}
