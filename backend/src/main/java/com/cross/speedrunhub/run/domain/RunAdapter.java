package com.cross.speedrunhub.run.domain;

import java.util.List;
import java.util.Optional;

public interface RunAdapter {
    
    Run save(Run run);
    Optional<Run> findById(Long id);
    List<Run> findAll();
    List<Run> findByMarathonId(Long marathonId);
    List<Run> findByRunnerId(Long runnerId);
    List<Run> findByGameId(Long gameId);
    void deleteById(Long id);
    boolean existsById(Long id);
}