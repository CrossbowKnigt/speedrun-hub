package com.cross.speedrunhub.run.application;

import com.cross.speedrunhub.run.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateRunUseCaseImpl implements UpdateRunUseCase {

    private final RunAdapter runAdapter;

    @Override
    public Run execute(UpdateRunCommand command) {
        Run run = runAdapter.findById(command.getId())
                .orElseThrow(() -> new RuntimeException("Run not found with id: " + command.getId()));
        
        run.setMarathonId(command.getMarathonId());
        run.setRunnerId(command.getRunnerId());
        run.setGameId(command.getGameId());
        run.setCategory(command.getCategory());
        run.setEstimate(command.getEstimate());
        run.setState(command.getState());
        run.setOrderInMarathon(command.getOrderInMarathon());
        run.setSetupTime(command.getSetupTime());
        
        return runAdapter.save(run);
    }
}