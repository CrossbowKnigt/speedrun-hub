package com.cross.speedrunhub.run.infrastructure.api;

import com.cross.speedrunhub.run.domain.*;
import com.cross.speedrunhub.run.infrastructure.api.dto.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RunApiMapper {
    
    RunDTO toDTO(Run run);
    CreateRunCommand toCreateCommand(PostRunBodyDTO postRunBodyDTO);
    
    default UpdateRunCommand toUpdateCommand(PutRunBodyDTO putRunBodyDTO, Long id) {
        UpdateRunCommand command = new UpdateRunCommand();
        command.setId(id);
        command.setMarathonId(putRunBodyDTO.getMarathonId());
        command.setRunnerId(putRunBodyDTO.getRunnerId());
        command.setGameId(putRunBodyDTO.getGameId());
        command.setCategory(putRunBodyDTO.getCategory());
        command.setEstimate(putRunBodyDTO.getEstimate());
        command.setState(putRunBodyDTO.getState());
        command.setOrderInMarathon(putRunBodyDTO.getOrderInMarathon());
        command.setSetupTime(putRunBodyDTO.getSetupTime());
        return command;
    }
}