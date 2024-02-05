package com.rmsoft.codingtest.Controller;

import com.rmsoft.codingtest.model.Subscription;
import com.rmsoft.codingtest.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Map;

@Controller
public class UserController {
    @GetMapping({"", "/"})
    public String index() {
        return "user/index";
    }
    @GetMapping("/auth/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user/updateForm")
    public String updateForm() {

        return "user/updateForm";
    }

}
