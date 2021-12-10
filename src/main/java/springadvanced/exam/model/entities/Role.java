package springadvanced.exam.model.entities;

import springadvanced.exam.model.BaseEntity;
import springadvanced.exam.model.enums.UserRoles;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private UserRoles role;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }
}
