package com.cross.speedrunhub.run.application;

import com.cross.speedrunhub.run.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteRunUseCaseImpl implements DeleteRunUseCase {

    private final RunAdapter runAdapter;

    @Override
    public void execute(Long id) {
        if (!runAdapter.existsById(id)) {
            throw new RuntimeException("Run not found with id: " + id);
        }
        runAdapter.deleteById(id);
    }
}