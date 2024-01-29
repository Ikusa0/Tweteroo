package com.driven.tweteroo.services;

import com.driven.tweteroo.models.User;
import com.driven.tweteroo.repositories.UserRepository;

public class UserService {
  private UserService() {
  }

  public static String addNewUser(User user) {
    User userExist = UserRepository.getUserByUsername(user.getUsername());
    if (userExist != null) {
      return "username isn't available";
    }

    UserRepository.addNewUser(user);

    return "user created";
  }

}
