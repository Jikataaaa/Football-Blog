package springadvanced.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springadvanced.exam.model.entities.Role;
import springadvanced.exam.model.enums.UserRoles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(UserRoles role);

}
