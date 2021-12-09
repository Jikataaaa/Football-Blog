package springadvanced.exam.model.binding;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    private String username;
    private String password;
    private String repeatPass;

    public UserRegisterBindingModel() {
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

    public String getRepeatPass() {
        return repeatPass;
    }

    public void setRepeatPass(String repeatPass) {
        this.repeatPass = repeatPass;
    }
}
