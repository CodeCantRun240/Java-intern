package backend.mapper;

import backend.model.CreateUser;
import backend.dto.EntityDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;


@Mapper(componentModel = "spring")
public interface GetUserMapper {
    @Mapping(target = "createdAt", expression = "java(java.time.ZonedDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.ZonedDateTime.now())")
    CreateUser toEntity(EntityDTO dto);
    EntityDTO toDTO(CreateUser entity);
    List<EntityDTO> toDTOList(List<CreateUser> users);

}
