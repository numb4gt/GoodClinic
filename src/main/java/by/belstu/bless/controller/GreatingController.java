package by.belstu.bless.controller;

import by.belstu.bless.model.Illness;
import by.belstu.bless.model.Role;
import by.belstu.bless.model.User;
import by.belstu.bless.repository.IllnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreatingController {

    @Autowired
    private IllnessRepository illnessRepository;

    @GetMapping("/")
    public String greeting() {
        return "redirect:/main";
    }

    @GetMapping("/hello")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {

        Iterable<Illness> illnesses= illnessRepository.findAll();
        model.put("illnesses", illnesses);

        return "hello";
    }

}