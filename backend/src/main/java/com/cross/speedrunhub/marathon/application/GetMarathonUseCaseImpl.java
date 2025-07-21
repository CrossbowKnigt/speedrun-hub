package com.cross.speedrunhub.marathon.application;

import com.cross.speedrunhub.marathon.domain.GetMarathonUseCase;
import com.cross.speedrunhub.marathon.domain.Marathon;
import com.cross.speedrunhub.marathon.domain.MarathonAdapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetMarathonUseCaseImpl implements GetMarathonUseCase {

    private final MarathonAdapter marathonAdapter;

    @Override
    public List<Marathon> getAllMarathons() {
        return marathonAdapter.getAllMarathons();
    }

    @Override
    public Marathon getMarathonById(Integer id) {
        return marathonAdapter.getMarathonById(id);
    }
}
