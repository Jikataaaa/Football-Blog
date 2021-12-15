package springadvanced.exam.model.binding;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    private String username;
    private String password;
    private String repeatPass;

    public UserRegisterBindingModel() {
    }


    @Size(min = 3)
    @NotNull
    @NotBlank
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Size(min = 3)
    @NotNull
    @NotBlank
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Size(min = 3)
    @NotNull
    @NotBlank
    public String getRepeatPass() {
        return repeatPass;
    }

    public void setRepeatPass(String repeatPass) {
        this.repeatPass = repeatPass;
    }
}
