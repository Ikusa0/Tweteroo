package com.driven.tweteroo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driven.tweteroo.models.User;
import com.driven.tweteroo.services.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class UserController {

  @PostMapping("/sign-up")
  public String createUser(@RequestBody User body) {
    return UserService.addNewUser(body);
  }
}
