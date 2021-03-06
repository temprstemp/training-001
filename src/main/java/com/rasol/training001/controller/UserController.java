package com.rasol.training001.controller;

import com.rasol.training001.model.dto.User;
import com.rasol.training001.response.RestResponseEntity;
import com.rasol.training001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping()
    public RestResponseEntity createUser(@RequestBody @Valid User user, HttpServletRequest request){
        userService.createUser(user);
        user.setPassword(null);

        return new RestResponseEntity(request, user);
    }

    @PostMapping("/login")
    public RestResponseEntity loginUser(@RequestBody @Valid User user,
                                        HttpServletRequest request,
                                        HttpSession httpSession){
        userService.loginUser(user, request, httpSession);
        user.setPassword(null);

        return new RestResponseEntity(request, user);
    }


}
