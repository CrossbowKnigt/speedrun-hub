package com.cross.speedrunhub.boot.marathon.infrastructure;

import com.cross.speedrunhub.boot.marathon.domain.CreateMarathonCommand;
import com.cross.speedrunhub.boot.marathon.domain.Marathon;
import com.cross.speedrunhub.boot.marathon.domain.MarathonAdapter;
import com.cross.speedrunhub.boot.marathon.domain.UpdateMarathonCommand;
import com.cross.speedrunhub.boot.marathon.infrastructure.database.MarathonJpa;
import com.cross.speedrunhub.boot.marathon.infrastructure.database.MarathonPostgresRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MarathonAdapterImpl implements MarathonAdapter {

    private final MarathonPostgresRepository marathonPostgresRepository;
    private final MarathonMapper marathonMapper;

    @Override
    public Marathon createMarathon(CreateMarathonCommand command) {

        log.info("Creating marathon with command: {}", command);
        try {
            MarathonJpa marathonJpa = marathonMapper.toJpa(command);

            return marathonMapper.toDomain(marathonPostgresRepository.save(marathonJpa));
        } catch (Exception e) {
            log.error("Error creating marathon: {}", e.getMessage());
            throw new RuntimeException("Failed to create marathon");
        }
    }

    @Override
    public Marathon updateMarathon(UpdateMarathonCommand command) {
        log.info("Updating marathon with command: {}", command);
        try {
            MarathonJpa marathonJpa = marathonMapper.toJpa(command);

            return marathonMapper.toDomain(marathonPostgresRepository.save(marathonJpa));
        } catch (Exception e) {
            log.error("Error updating marathon: {}", e.getMessage());
            throw new RuntimeException("Failed to update marathon");
        }
    }
}
