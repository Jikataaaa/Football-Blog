package springadvanced.exam.model.service;

import springadvanced.exam.model.enums.PlayerPositions;

public class PlayerServiceModel {

    private Long id;
    private String name;
    private String description;
    private PlayerPositions position;

    public PlayerServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
