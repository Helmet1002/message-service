package com.computers.appolo.controller;


import com.computers.appolo.entity.User;
import com.computers.appolo.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public User profile(@AuthenticationPrincipal UserDetails principal) {

        return userService.findByUsername(principal.getUsername());
    }
}

