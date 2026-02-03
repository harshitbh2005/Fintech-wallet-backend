package com.paytmclone.wallet_system.controller;

import com.paytmclone.wallet_system.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String email,
                         @RequestParam String password) {

        userService.register(email, password);
        return "User registered with demo wallet";
    }
}

