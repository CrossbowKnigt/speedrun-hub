package com.cross.speedrunhub.run.application;

import com.cross.speedrunhub.run.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateRunUseCaseImpl implements CreateRunUseCase {

    private final RunAdapter runAdapter;

    @Override
    public Run execute(CreateRunCommand command) {
        Run run = new Run();
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