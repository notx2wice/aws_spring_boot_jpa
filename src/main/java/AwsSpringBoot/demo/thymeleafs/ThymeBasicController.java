package AwsSpringBoot.demo.thymeleafs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ThymeBasicController {

    @GetMapping("thymeleaf")
    public String index(){
        return "tlbasic/tlindex";
    }

    //@ResponseBody
    @GetMapping("thymeleaf/text")
    public String showText(Model model){
        model.addAttribute("data", "this data moved by model and recognized by th");
        return "tlbasic/text-basic";
    }
}
