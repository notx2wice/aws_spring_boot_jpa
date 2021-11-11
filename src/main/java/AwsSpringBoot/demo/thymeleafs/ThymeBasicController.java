package AwsSpringBoot.demo.thymeleafs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basic")
public class ThymeBasicController {

    @GetMapping("index")
    public String index(){
        return "basic/index";
    }

    //@ResponseBody
    @GetMapping("text-basic")
    public String showText(Model model){
        model.addAttribute("data", " Hello <b>Spring!</b>");
        return "basic/text-basic";
    }
}
