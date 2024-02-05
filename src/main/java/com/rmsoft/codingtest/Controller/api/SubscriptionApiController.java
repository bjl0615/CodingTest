package com.rmsoft.codingtest.Controller.api;

import com.rmsoft.codingtest.dto.ResponseDto;
import com.rmsoft.codingtest.model.Subscription;
import com.rmsoft.codingtest.service.SubService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription")
public class SubscriptionApiController {

    @Autowired
    SubService subService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public ResponseDto<Integer> crate(@RequestBody Subscription subscription) {
        System.out.println("SubscriptionApiController 호출 : ");
        subService.create(subscription);
        return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/useUpdate")
    public ResponseDto<Integer> useStorage(@RequestBody Subscription subscription) {
        subService.useStorage(subscription);
        return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/modify")
    public ResponseDto<Integer> modify(@RequestBody Subscription subscription) {
        subService.modify(subscription);
        return new ResponseDto<Integer>(HttpStatus.OK.value() , 1);
    }

}
