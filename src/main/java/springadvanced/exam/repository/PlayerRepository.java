package springadvanced.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springadvanced.exam.model.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
