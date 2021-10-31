package AwsSpringBoot.demo.web;

import AwsSpringBoot.demo.web.dto.HelloResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/hello")
    public String hello(){
        return "hi it is maked by response body annotation";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount")int amount)
    {
        return new HelloResponseDto(name, amount);
    }
}
