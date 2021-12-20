package springadvanced.exam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import springadvanced.exam.service.UserService;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/admin")
    public ModelAndView admin(){
        ModelAndView mav = new ModelAndView("admin");
        mav.addObject("users",userService.loadAllUsers());
        return mav;
    }

    @PostMapping("/admin/{id}")
    public String delete(@PathVariable Long id){

        userService.deleteUser(id);

        return "redirect:/";

    }

}
