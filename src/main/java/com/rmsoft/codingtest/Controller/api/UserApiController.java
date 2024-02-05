package com.rmsoft.codingtest.Controller.api;

import com.rmsoft.codingtest.dto.ResponseDto;
import com.rmsoft.codingtest.mapper.UserMapper;
import com.rmsoft.codingtest.model.User;
import com.rmsoft.codingtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserApiController {

    @Autowired
    private  UserService userService;


    @PostMapping("/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController 호출 : save 호출");
        userService.join(user);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user) {
        System.out.println(user.getEmail());
        userService.update(user);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }
}
