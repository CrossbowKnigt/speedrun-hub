package com.cross.speedrunhub.run.domain;

import java.util.List;
import java.util.Optional;

public interface GetRunUseCase {
    
    Optional<Run> findById(Long id);
    List<Run> findAll();
    List<Run> findByMarathonId(Long marathonId);
    List<Run> findByRunnerId(Long runnerId);
    List<Run> findByGameId(Long gameId);
}