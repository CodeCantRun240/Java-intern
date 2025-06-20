package backend.repository;

import backend.model.CreateUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaging extends JpaRepository<CreateUser, Long> {

    @Query(
            value = """
           SELECT * FROM user_info 
           WHERE (:position IS NULL OR LOWER(position) = LOWER(:position)) 
             AND (:user_name IS NULL OR LOWER(user_name) = LOWER(:user_name))
           """,
            countQuery = """
           SELECT COUNT(*) FROM user_info 
           WHERE (:position IS NULL OR LOWER(position) = LOWER(:position)) 
             AND (:user_name IS NULL OR LOWER(user_name) = LOWER(:user_name))
           """,
            nativeQuery = true
    )
    Page<CreateUser> findBy(
            @Param("position") String position,
            @Param("user_name") String user_name,
            Pageable pageable
    );
}
