package com.cross.speedrunhub.boot.marathon.infrastructure;

import com.cross.speedrunhub.boot.marathon.domain.CreateMarathonCommand;
import com.cross.speedrunhub.boot.marathon.domain.Marathon;
import com.cross.speedrunhub.boot.marathon.domain.UpdateMarathonCommand;
import com.cross.speedrunhub.boot.marathon.infrastructure.database.MarathonJpa;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarathonMapper {

    Marathon toDomain(MarathonJpa marathonJpa);

    MarathonJpa toJpa(CreateMarathonCommand createMarathonCommand);

    MarathonJpa toJpa(UpdateMarathonCommand updateMarathonCommand);
}
