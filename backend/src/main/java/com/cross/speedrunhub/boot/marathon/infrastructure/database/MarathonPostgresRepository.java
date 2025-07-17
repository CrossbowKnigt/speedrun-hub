package com.cross.speedrunhub.boot.marathon.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarathonPostgresRepository extends JpaRepository<MarathonJpa, Integer> {}
