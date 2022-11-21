package by.belstu.bless.controller;

import by.belstu.bless.model.Illness;
import by.belstu.bless.model.Role;
import by.belstu.bless.model.User;
import by.belstu.bless.repository.IllnessRepository;
import by.belstu.bless.repository.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;



@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private UserRepositiry userRepositiry;

    @Autowired
    private IllnessRepository illnessRepository;

    @GetMapping
    public String doctorMain(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        return "doctormain";
    }

    @GetMapping("patientlist")
    public String userList(Model model) {
        model.addAttribute("users", userRepositiry.findAll());
        return "doctorlist";
    }

    @GetMapping("mydestination")
    public String userDesenition(Model model, @AuthenticationPrincipal User user) {
        Iterable<Illness> illnesses= illnessRepository.findAll();

        model.addAttribute("illnesses", illnessRepository.findByUser(user));
        return "doctordestination";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "doctoredit";
    }

    @PostMapping
    public String userSave(@AuthenticationPrincipal User user, @RequestParam String text,
                           @RequestParam String tag, Map<String, Object> model, @RequestParam("userID") User user2
    ) {

        System.err.println(tag);

        Illness message = new Illness(text, tag, user, user2);

        illnessRepository.save(message);

        return "redirect:/doctor/patientlist";
    }

//    @PostMapping("/patientlist")
//    public String findDist(@RequestParam String filter, Map<String, Object> model){
//        Iterable<User> messages;
//
//        System.err.println(filter);
//
////        if (filter != null && !filter.isEmpty()) {
////            messages = (Iterable<User>) userRepositiry.findByUsername(filter);
////        } else {
////            messages = userRepositiry.findAll();
////        }
////
////        model.put("users", messages);
//
//        return "redirect:/doctor/patientlist";
//    }

    @PostMapping("/mydestination")
    public String findUser(@RequestParam String filter, Map<String, Object> model, @AuthenticationPrincipal User user){
        Iterable<Illness> messages;

        System.err.println(filter);

        if (filter != null && !filter.isEmpty()) {
            messages = illnessRepository.findByTagAndUser(filter, user);
        } else {
            messages = illnessRepository.findByUser(user);
        }

        model.put("illnesses", messages);

        return "redirect:/doctor/mydestination";
    }


}