package com.cross.speedrunhub.marathon.infrastructure.adapter;

import com.cross.speedrunhub.error.domain.NotFoundException;
import com.cross.speedrunhub.marathon.domain.CreateMarathonCommand;
import com.cross.speedrunhub.marathon.domain.Marathon;
import com.cross.speedrunhub.marathon.domain.MarathonAdapter;
import com.cross.speedrunhub.marathon.domain.UpdateMarathonCommand;
import com.cross.speedrunhub.marathon.infrastructure.adapter.database.MarathonJpa;
import com.cross.speedrunhub.marathon.infrastructure.adapter.database.MarathonPostgresRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Marathon getMarathonById(Integer id) {

        log.info("Retrieving marathon by ID: {}", id);
        Optional<MarathonJpa> marathonJpa = marathonPostgresRepository.findById(id);
        if (marathonJpa.isPresent()) {
            return marathonMapper.toDomain(marathonJpa.get());
        }
        log.warn("Marathon with ID {} not found", id);
        throw new NotFoundException("Marathon not found with ID: " + id);
    }

    @Override
    public List<Marathon> getAllMarathons() {
        log.info("Retrieving all marathons");

        return this.marathonMapper.toDomainList(marathonPostgresRepository.findAll());
    }

    @Override
    public void deleteMarathon(Integer id) {

        marathonPostgresRepository.deleteById(id);
    }
}
