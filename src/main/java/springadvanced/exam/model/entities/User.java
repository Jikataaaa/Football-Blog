package springadvanced.exam.model.entities;

import springadvanced.exam.model.BaseEntity;
import springadvanced.exam.model.enums.UserRoles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private UserRoles role;

    public User() {
    }
    @Column(unique = true)
    @Size(min = 3)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Size(min = 3)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated
    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }
}

