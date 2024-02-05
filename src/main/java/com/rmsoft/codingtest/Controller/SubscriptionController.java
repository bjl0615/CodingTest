package com.rmsoft.codingtest.Controller;

import com.rmsoft.codingtest.model.Subscription;
import com.rmsoft.codingtest.service.SubService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SubscriptionController {

    @Autowired
    SubService subService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String subCreate() {
        return "sub/create";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/success")
    public String success() {
        return "user/index";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/sub/{username}")
    public String getSubscriptionById(@PathVariable String username, Model model) {
        Subscription subscription = subService.getSubscriptionByUsername(username);
        model.addAttribute("subscription" , subscription);
        return "sub/UserDetail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/UserAllState")
    public String UserAllState(Model model) {
        List<Subscription> userList = subService.getAllUser();
        model.addAttribute("list" , userList);
        return "sub/UserAllState";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/use")
    public String use() {
        return "use/capacity";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/sub/update/{username}")
    public String updateSubscription(@PathVariable String username , Model model) {
        Subscription subscription = subService.getSubscriptionByUsername(username);
        model.addAttribute("subscription" , subscription);
        return "sub/update";
    }

}
