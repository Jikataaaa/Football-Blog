package springadvanced.exam.service;

import springadvanced.exam.model.service.PlayerServiceModel;

import java.util.List;

public interface PlayerService {

    List<PlayerServiceModel> loadAllPlayers();

    void addPlayer(PlayerServiceModel playerServiceModel);

}
