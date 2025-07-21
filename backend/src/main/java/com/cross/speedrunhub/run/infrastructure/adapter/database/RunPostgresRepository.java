package com.cross.speedrunhub.run.infrastructure.adapter.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunPostgresRepository extends JpaRepository<RunJpa, Long> {
    
    List<RunJpa> findByMarathonId(Long marathonId);
    List<RunJpa> findByRunnerId(Long runnerId);
    List<RunJpa> findByGameId(Long gameId);
}