package web.pocket4cut.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.pocket4cut.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
