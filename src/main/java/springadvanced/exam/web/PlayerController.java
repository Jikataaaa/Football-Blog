package springadvanced.exam.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springadvanced.exam.model.binding.PlayerAddBindingModel;
import springadvanced.exam.model.service.PlayerServiceModel;
import springadvanced.exam.service.PlayerService;

import javax.validation.Valid;

@Controller
public class PlayerController {

    private final PlayerService playerService;
    private final ModelMapper modelMapper;

    public PlayerController(PlayerService playerService, ModelMapper modelMapper) {
        this.playerService = playerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("player-add")
    public String add(){
        return "newPlayer";
    }

    @PostMapping("player-add")
    public String addConfirm(@Valid PlayerAddBindingModel playerAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("playerAddBindingModel", playerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.playerAddBindingModel", bindingResult);

            return "redirect:/player-add";
        }
        PlayerServiceModel playerServiceModel = modelMapper.map(playerAddBindingModel, PlayerServiceModel.class);
        playerService.addPlayer(playerServiceModel);

        //TODO to create a page with visible players
        return "hh";
    }

    @ModelAttribute
    public PlayerAddBindingModel playerAddBindingModel(){
        return new PlayerAddBindingModel();
    }


}
