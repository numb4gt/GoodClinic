package by.belstu.bless.controller;

import by.belstu.bless.repository.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserControler {

    @Autowired
    private UserRepositiry userRepositiry;


}
