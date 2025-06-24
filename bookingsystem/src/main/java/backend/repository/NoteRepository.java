package backend.repository;


import backend.model.CreateNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<CreateNote, Long> {

    @Query("SELECT n FROM CreateNote n WHERE n.userId = :userId")
    List<CreateNote> findByUserId(@Param("userId") Long userId);
}
