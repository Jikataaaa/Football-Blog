package springadvanced.exam.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springadvanced.exam.model.binding.PostAddBindingModel;
import springadvanced.exam.model.service.PostServiceModel;
import springadvanced.exam.service.PostService;

import javax.validation.Valid;

@Controller
public class PostController {

    private final PostService service;
    private final ModelMapper mapper;

    public PostController(PostService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    @GetMapping("post-add")
    public String add(){
        return "newPost";
    }

    @PostMapping("post-add")
    public String addConfirm(@Valid PostAddBindingModel postAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("postAddBindingModel", postAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postAddBindingModel", bindingResult);
            return "redirect:/post-add";
        }

        PostServiceModel postServiceModel = mapper.map(postAddBindingModel, PostServiceModel.class);
        service.addPost(postServiceModel);

        //TODO redirect to page where posts will be visible


        return "jj";
    }



}
