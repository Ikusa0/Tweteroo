package com.driven.tweteroo.repositories;

import java.util.List;

import com.driven.tweteroo.db.FakeDB;
import com.driven.tweteroo.models.User;

public class UserRepository {
  private UserRepository() {
  }

  public static User getUserByUsername(String username) {
    List<User> dbUsers = FakeDB.Users.get();
    for (User user: dbUsers) {
      if(user.getUsername().equals(username)) {
        return user;
      }
    }
    return null;
  }

  public static void addNewUser(User newUser) {
    FakeDB.Users.add(newUser);
  }
}
