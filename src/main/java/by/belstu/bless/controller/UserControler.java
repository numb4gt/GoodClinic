package by.belstu.bless.controller;

import by.belstu.bless.model.Illness;
import by.belstu.bless.model.User;
import by.belstu.bless.repository.IllnessRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("/main")
public class UserControler {

    @Autowired
    private IllnessRepository illnessRepository;

    @GetMapping()
    public String doctorMain(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        return "main";
    }

    @GetMapping("myill")
    public String userList(Map<String, Object> model, @AuthenticationPrincipal User user) {
        Iterable<Illness> illnesses= illnessRepository.findByUserfor(user);
        model.put("illnesses", illnesses);
        return "mainilllist";
    }

    @GetMapping("myvisit")
    public String userVisit(Model model) {
        return "mainvisit";
    }


    @PostMapping
    public String filter(@RequestParam String filter, Map<String, Object> model, @AuthenticationPrincipal User user) {
        Iterable<Illness> messages;

        System.err.println(filter);

        if (filter != null && !filter.isEmpty()) {
            messages = illnessRepository.findByTagAndUserfor(filter, user);
        } else {
            messages = illnessRepository.findByUserfor(user);
        }

        model.put("illnesses", messages);

        return "mainilllist";
    }

}
