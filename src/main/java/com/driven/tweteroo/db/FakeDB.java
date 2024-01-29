package com.driven.tweteroo.db;

import java.util.ArrayList;
import java.util.List;

import com.driven.tweteroo.models.Tweet;
import com.driven.tweteroo.models.User;

public class FakeDB {
  private FakeDB() {
  }

  private static List<User> users = new ArrayList<>();
  private static List<Tweet> tweets = new ArrayList<>();

  public static class Users {
    private Users() {
    }

    public static List<User> get() {
      return users;
    }

    public static void add(User newUser) {
      users.add(newUser);
      System.out.println(users);
    }
  }

  public static class Tweets {
    private Tweets() {
    }

    public static List<Tweet> get() {
      return tweets;
    }

    public static void add(Tweet newTweet) {
      tweets.add(newTweet);
      System.out.println(tweets);
    }
  }
}
