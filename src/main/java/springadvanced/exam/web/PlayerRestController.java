package springadvanced.exam.web;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springadvanced.exam.model.service.PlayerServiceModel;
import springadvanced.exam.service.PlayerService;

import java.util.List;

@RestController
public class PlayerRestController {

    private final PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;

    }

    @GetMapping("/api/players")
    public ResponseEntity<List<PlayerServiceModel>> getPlayers(){

        return ResponseEntity.ok(playerService.loadAllPlayers());

    }

}
