package backend.mapper;

import backend.model.CreateUser;
import backend.dto.EntityDTO;

import org.mapstruct.Mapper;


import java.util.List;


@Mapper(componentModel = "spring")
public interface GetUserMapper {

    CreateUser toEntity(EntityDTO dto);
    EntityDTO toDTO(CreateUser entity);
    List<EntityDTO> toDTOList(List<CreateUser> users);

}
