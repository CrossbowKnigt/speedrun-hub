package com.cross.speedrunhub.marathon.infrastructure.adapter;

import com.cross.speedrunhub.marathon.domain.CreateMarathonCommand;
import com.cross.speedrunhub.marathon.domain.Marathon;
import com.cross.speedrunhub.marathon.domain.UpdateMarathonCommand;
import com.cross.speedrunhub.marathon.infrastructure.adapter.database.MarathonJpa;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarathonMapper {

    Marathon toDomain(MarathonJpa marathonJpa);

    MarathonJpa toJpa(CreateMarathonCommand createMarathonCommand);

    MarathonJpa toJpa(UpdateMarathonCommand updateMarathonCommand);
}
