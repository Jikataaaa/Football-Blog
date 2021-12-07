package springadvanced.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springadvanced.exam.model.entities.Player;
import springadvanced.exam.model.service.PlayerServiceModel;
import springadvanced.exam.repository.PlayerRepository;
import springadvanced.exam.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository repository;
    private final ModelMapper mapper;

    public PlayerServiceImpl(PlayerRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void addPlayer(PlayerServiceModel playerServiceModel) {
        repository.save(mapper.map(playerServiceModel, Player.class));
    }
}
