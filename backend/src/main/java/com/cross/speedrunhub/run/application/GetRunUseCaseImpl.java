package com.cross.speedrunhub.run.application;

import com.cross.speedrunhub.run.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetRunUseCaseImpl implements GetRunUseCase {

    private final RunAdapter runAdapter;

    @Override
    public Optional<Run> findById(Long id) {
        return runAdapter.findById(id);
    }

    @Override
    public List<Run> findAll() {
        return runAdapter.findAll();
    }

    @Override
    public List<Run> findByMarathonId(Long marathonId) {
        return runAdapter.findByMarathonId(marathonId);
    }

    @Override
    public List<Run> findByRunnerId(Long runnerId) {
        return runAdapter.findByRunnerId(runnerId);
    }

    @Override
    public List<Run> findByGameId(Long gameId) {
        return runAdapter.findByGameId(gameId);
    }
}