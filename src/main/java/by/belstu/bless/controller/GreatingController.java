package by.belstu.bless.controller;

import by.belstu.bless.model.Illness;
import by.belstu.bless.repository.IllnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class GreatingController {

    @Autowired
    private IllnessRepository illnessRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "hello";
    }

    @GetMapping("/hello")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "hello";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Illness> illnesses= illnessRepository.findAll();

        model.put("illnesses", illnesses);
        return "main";
    }

    @PostMapping("add")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Illness message = new Illness(text, tag);

        illnessRepository.save(message);

        Iterable<Illness> messages = illnessRepository.findAll();

        model.put("illnesses", messages);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Illness> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = illnessRepository.findByTag(filter);
        } else {
            messages = illnessRepository.findAll();
        }

        model.put("illnesses", messages);

        return "main";
    }
}