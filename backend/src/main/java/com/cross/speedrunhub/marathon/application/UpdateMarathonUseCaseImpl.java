package com.cross.speedrunhub.marathon.application;

import com.cross.speedrunhub.marathon.domain.Marathon;
import com.cross.speedrunhub.marathon.domain.MarathonAdapter;
import com.cross.speedrunhub.marathon.domain.UpdateMarathonCommand;
import com.cross.speedrunhub.marathon.domain.UpdateMarathonUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateMarathonUseCaseImpl implements UpdateMarathonUseCase {

    private final MarathonAdapter marathonAdapter;

    @Override
    public Marathon updateMarathon(UpdateMarathonCommand updateMarathonCommand) {
        return marathonAdapter.updateMarathon(updateMarathonCommand);
    }
}
