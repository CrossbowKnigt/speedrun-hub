package com.cross.speedrunhub.marathon.application;

import com.cross.speedrunhub.marathon.domain.CreateMarathonCommand;
import com.cross.speedrunhub.marathon.domain.CreateMarathonUseCase;
import com.cross.speedrunhub.marathon.domain.Marathon;
import com.cross.speedrunhub.marathon.domain.MarathonAdapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateMarathonUseCaseImpl implements CreateMarathonUseCase {

    private final MarathonAdapter marathonAdapter;

    @Override
    public Marathon createMarathon(CreateMarathonCommand createMarathonCommand) {
        return marathonAdapter.createMarathon(createMarathonCommand);
    }
}
