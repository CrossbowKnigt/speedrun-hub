package com.cross.speedrunhub.marathon.application;

import com.cross.speedrunhub.marathon.domain.DeleteMarathonUseCase;
import com.cross.speedrunhub.marathon.domain.MarathonAdapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteMarathonUseCaseImpl implements DeleteMarathonUseCase {

    private final MarathonAdapter marathonAdapter;

    @Override
    public void deleteMarathon(Integer id) {
        marathonAdapter.deleteMarathon(id);
    }
}
