package springadvanced.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springadvanced.exam.model.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
