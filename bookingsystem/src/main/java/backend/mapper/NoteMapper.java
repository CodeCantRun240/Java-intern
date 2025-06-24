package backend.mapper;

import backend.dto.NoteDTO;
import backend.model.CreateNote;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {


    CreateNote toEntity(NoteDTO dto);
    NoteDTO toDTO(CreateNote entity);
    List<NoteDTO> toDTOList(List<CreateNote> entities);
}
