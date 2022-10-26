package by.belstu.bless.controller;

import by.belstu.bless.model.Role;
import by.belstu.bless.model.User;
import by.belstu.bless.repository.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrtionControler {
    @Autowired
    private UserRepositiry userRepositiry;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDB = userRepositiry.findByUsername(user.getUsername());

        if(userFromDB != null) {
            model.put("message", "User exist!!!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.User));
        userRepositiry.save(user);

        return "redirect:/login";
    }
}
