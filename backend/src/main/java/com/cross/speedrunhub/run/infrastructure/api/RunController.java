package com.cross.speedrunhub.run.infrastructure.api;

import com.cross.speedrunhub.run.domain.*;
import com.cross.speedrunhub.run.infrastructure.api.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/runs")
@RequiredArgsConstructor
public class RunController {

    private final CreateRunUseCase createRunUseCase;
    private final UpdateRunUseCase updateRunUseCase;
    private final GetRunUseCase getRunUseCase;
    private final DeleteRunUseCase deleteRunUseCase;
    private final RunApiMapper runApiMapper;

    @PostMapping
    public ResponseEntity<RunDTO> createRun(@RequestBody PostRunBodyDTO postRunBodyDTO) {
        var command = runApiMapper.toCreateCommand(postRunBodyDTO);
        var run = createRunUseCase.execute(command);
        var runDTO = runApiMapper.toDTO(run);
        return ResponseEntity.status(HttpStatus.CREATED).body(runDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RunDTO> getRunById(@PathVariable Long id) {
        return getRunUseCase.findById(id)
                .map(run -> ResponseEntity.ok(runApiMapper.toDTO(run)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<RunDTO>> getAllRuns() {
        var runs = getRunUseCase.findAll();
        var runDTOs = runs.stream()
                .map(runApiMapper::toDTO)
                .toList();
        return ResponseEntity.ok(runDTOs);
    }

    @GetMapping("/marathon/{marathonId}")
    public ResponseEntity<List<RunDTO>> getRunsByMarathonId(@PathVariable Long marathonId) {
        var runs = getRunUseCase.findByMarathonId(marathonId);
        var runDTOs = runs.stream()
                .map(runApiMapper::toDTO)
                .toList();
        return ResponseEntity.ok(runDTOs);
    }

    @GetMapping("/runner/{runnerId}")
    public ResponseEntity<List<RunDTO>> getRunsByRunnerId(@PathVariable Long runnerId) {
        var runs = getRunUseCase.findByRunnerId(runnerId);
        var runDTOs = runs.stream()
                .map(runApiMapper::toDTO)
                .toList();
        return ResponseEntity.ok(runDTOs);
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<RunDTO>> getRunsByGameId(@PathVariable Long gameId) {
        var runs = getRunUseCase.findByGameId(gameId);
        var runDTOs = runs.stream()
                .map(runApiMapper::toDTO)
                .toList();
        return ResponseEntity.ok(runDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RunDTO> updateRun(@PathVariable Long id, @RequestBody PutRunBodyDTO putRunBodyDTO) {
        var command = runApiMapper.toUpdateCommand(putRunBodyDTO, id);
        var run = updateRunUseCase.execute(command);
        var runDTO = runApiMapper.toDTO(run);
        return ResponseEntity.ok(runDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRun(@PathVariable Long id) {
        deleteRunUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}