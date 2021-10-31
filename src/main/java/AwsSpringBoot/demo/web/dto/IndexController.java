package AwsSpringBoot.demo.web.dto;

import AwsSpringBoot.demo.config.auth.dto.SessionUser;
import AwsSpringBoot.demo.domain.user.UserRepository;
import AwsSpringBoot.demo.service.posts.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostService postService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave(){
        return "post-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id , Model model){
        PostResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);
        return "post-update";
    }


}
