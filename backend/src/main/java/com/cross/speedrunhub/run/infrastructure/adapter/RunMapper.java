package com.cross.speedrunhub.run.infrastructure.adapter;

import com.cross.speedrunhub.run.domain.Run;
import com.cross.speedrunhub.run.infrastructure.adapter.database.RunJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RunMapper {
    
    Run toDomain(RunJpa runJpa);
    RunJpa toJpa(Run run);
}