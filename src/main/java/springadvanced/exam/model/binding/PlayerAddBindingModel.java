package springadvanced.exam.model.binding;


import springadvanced.exam.model.enums.PlayerPositions;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlayerAddBindingModel {

    private String name;
    private String description;
    private PlayerPositions position;

    public PlayerAddBindingModel() {
    }
    @NotNull
    @Size(min = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    public PlayerPositions getPosition() {
        return position;
    }

    public void setPosition(PlayerPositions position) {
        this.position = position;
    }
}
