package com.cross.speedrunhub.marathon.infrastructure.api;

import com.cross.speedrunhub.marathon.domain.*;
import com.cross.speedrunhub.marathon.infrastructure.api.dto.MarathonDTO;
import com.cross.speedrunhub.marathon.infrastructure.api.dto.PostMarathonBodyDTO;
import com.cross.speedrunhub.marathon.infrastructure.api.dto.PutMarathonBodyDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/marathons")
@RequiredArgsConstructor
public class MarathonController {

    private final MarathonApiMapper marathonApiMapper;

    private final CreateMarathonUseCase createMarathonUseCase;

    private final UpdateMarathonUseCase updateMarathonUseCase;

    private final GetMarathonUseCase getMarathonsUseCase;

    @PostMapping
    public ResponseEntity<MarathonDTO> createMarathon(
            @RequestBody PostMarathonBodyDTO postMarathonBodyDTO) {

        CreateMarathonCommand command =
                marathonApiMapper.toCreateMarathonCommand(postMarathonBodyDTO);
        Marathon marathon = createMarathonUseCase.createMarathon(command);

        return ResponseEntity.ok(marathonApiMapper.toMarathonDTO(marathon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarathonDTO> updateMarathon(
            @PathVariable("id") Integer id, @RequestBody PutMarathonBodyDTO putMarathonBodyDTO) {

        UpdateMarathonCommand command =
                marathonApiMapper.toUpdateMarathonCommand(id, putMarathonBodyDTO);
        Marathon marathon = updateMarathonUseCase.updateMarathon(command);

        return ResponseEntity.ok(marathonApiMapper.toMarathonDTO(marathon));
    }

    @GetMapping
    public ResponseEntity<List<MarathonDTO>> getMarathons() {

        // TODO: add criteria
        List<Marathon> marathons = getMarathonsUseCase.getAllMarathons();

        return ResponseEntity.ok(marathonApiMapper.toMarathonListDTO(marathons));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarathonDTO> getMarathonById(@PathVariable("id") Integer id) {

        // TODO: add criteria
        Marathon marathon = getMarathonsUseCase.getMarathonById(id);

        return ResponseEntity.ok(marathonApiMapper.toMarathonDTO(marathon));
    }
}
