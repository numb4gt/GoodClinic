package by.belstu.bless.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class GreatingController {

    @GetMapping("/hello")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "hello";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "Pavel!");
        return "main";
    }
}