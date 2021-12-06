package springadvanced.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springadvanced.exam.model.entities.User;

@Repository
public interface UserRepository extends JpaRepository<Long, User> {
}
