package com.cross.speedrunhub.marathon.infrastructure.adapter.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarathonPostgresRepository extends JpaRepository<MarathonJpa, Integer> {}
