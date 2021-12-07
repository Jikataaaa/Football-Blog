package springadvanced.exam.model.entities;

import springadvanced.exam.model.BaseEntity;
import springadvanced.exam.model.enums.PlayerPositions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    private String name;
    private String description;
    private PlayerPositions position;

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(columnDefinition = "TEXT")
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
