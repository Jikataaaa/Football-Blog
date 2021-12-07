package springadvanced.exam.model.binding;


import springadvanced.exam.model.enums.PlayerPositions;

public class PlayerAddBindingModel {

    private String name;
    private String description;
    private PlayerPositions position;

    public PlayerAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PlayerPositions getPosition() {
        return position;
    }

    public void setPosition(PlayerPositions position) {
        this.position = position;
    }
}
