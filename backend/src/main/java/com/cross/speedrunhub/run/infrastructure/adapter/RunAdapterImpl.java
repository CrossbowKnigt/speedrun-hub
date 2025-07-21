package com.cross.speedrunhub.run.infrastructure.adapter;

import com.cross.speedrunhub.run.domain.Run;
import com.cross.speedrunhub.run.domain.RunAdapter;
import com.cross.speedrunhub.run.infrastructure.adapter.database.RunPostgresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RunAdapterImpl implements RunAdapter {

    private final RunPostgresRepository runPostgresRepository;
    private final RunMapper runMapper;

    @Override
    public Run save(Run run) {
        var runJpa = runMapper.toJpa(run);
        var savedRunJpa = runPostgresRepository.save(runJpa);
        return runMapper.toDomain(savedRunJpa);
    }

    @Override
    public Optional<Run> findById(Long id) {
        return runPostgresRepository.findById(id)
                .map(runMapper::toDomain);
    }

    @Override
    public List<Run> findAll() {
        return runPostgresRepository.findAll()
                .stream()
                .map(runMapper::toDomain)
                .toList();
    }

    @Override
    public List<Run> findByMarathonId(Long marathonId) {
        return runPostgresRepository.findByMarathonId(marathonId)
                .stream()
                .map(runMapper::toDomain)
                .toList();
    }

    @Override
    public List<Run> findByRunnerId(Long runnerId) {
        return runPostgresRepository.findByRunnerId(runnerId)
                .stream()
                .map(runMapper::toDomain)
                .toList();
    }

    @Override
    public List<Run> findByGameId(Long gameId) {
        return runPostgresRepository.findByGameId(gameId)
                .stream()
                .map(runMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        runPostgresRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return runPostgresRepository.existsById(id);
    }
}