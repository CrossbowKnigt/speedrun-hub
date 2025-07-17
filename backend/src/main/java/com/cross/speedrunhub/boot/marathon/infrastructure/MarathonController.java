package com.cross.speedrunhub.boot.marathon.infrastructure;

import com.cross.speedrunhub.boot.marathon.domain.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/marathons")
@RequiredArgsConstructor
public class MarathonController {

    private final CreateMarathonUseCase createMarathonUseCase;

    private final UpdateMarathonUseCase updateMarathonUseCase;

    // This class will handle HTTP requests related to marathons.
    // It will use the services defined in the application layer to perform operations.
    // For example, it can have methods to create, update, delete, and retrieve marathons.

    @PostMapping
    public ResponseEntity<Marathon> createMarathon(@RequestBody CreateMarathonCommand command) {
        Marathon marathon = createMarathonUseCase.createMarathon(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(marathon);
    }

    @PutMapping
    public ResponseEntity<Marathon> updateMarathon(@RequestBody UpdateMarathonCommand command) {
        Marathon marathon = updateMarathonUseCase.updateMarathon(command);
        return ResponseEntity.status(HttpStatus.OK).body(marathon);
    }
}
