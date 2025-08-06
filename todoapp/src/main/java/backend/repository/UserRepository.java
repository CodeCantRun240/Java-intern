package backend.repository;

import backend.model.CreateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CreateUser, Long> {
    boolean existsByEmail(String email);
    //Optional<CreateUser> findByUsername(String userName);
    Optional<CreateUser> findByEmail(String email);
}
