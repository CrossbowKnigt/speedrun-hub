package com.cross.speedrunhub.marathon.infrastructure.api;

import com.cross.speedrunhub.marathon.domain.CreateMarathonCommand;
import com.cross.speedrunhub.marathon.domain.Marathon;
import com.cross.speedrunhub.marathon.domain.UpdateMarathonCommand;
import com.cross.speedrunhub.marathon.infrastructure.api.dto.MarathonDTO;
import com.cross.speedrunhub.marathon.infrastructure.api.dto.PostMarathonBodyDTO;
import com.cross.speedrunhub.marathon.infrastructure.api.dto.PutMarathonBodyDTO;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarathonApiMapper {

    MarathonDTO toMarathonDTO(Marathon marathon);

    List<MarathonDTO> toMarathonListDTO(List<Marathon> marathons);

    CreateMarathonCommand toCreateMarathonCommand(PostMarathonBodyDTO postMarathonBodyDTO);

    UpdateMarathonCommand toUpdateMarathonCommand(
            Integer id, PutMarathonBodyDTO putMarathonBodyDTO);
}
