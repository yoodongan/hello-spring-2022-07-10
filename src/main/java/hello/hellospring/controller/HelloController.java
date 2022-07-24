package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")  //  /hello url과 연결한다.
    public String hello(Model model) {
        model.addAttribute("data", "YOO입니다.");
        return "hello";  // hello.html
    }
    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

}
