package backend.model;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.ZonedDateTime;

@Entity
@Table(name = "note_list")
public class CreateNote {
    private static final Logger log = LoggerFactory.getLogger(CreateNote.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "note_id")
    private Long noteId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "note_content")
    private String noteContent;

}
