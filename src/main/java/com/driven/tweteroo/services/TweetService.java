package com.driven.tweteroo.services;

import java.util.ArrayList;
import java.util.List;

import com.driven.tweteroo.dto.TweetRequest;
import com.driven.tweteroo.models.User;
import com.driven.tweteroo.models.Tweet;
import com.driven.tweteroo.repositories.TweetRepository;
import com.driven.tweteroo.repositories.UserRepository;

public class TweetService {
  private TweetService() {
  }

  public static String addNewTweet(TweetRequest tweet) {
    User userExist = UserRepository.getUserByUsername(tweet.getUsername());
    if (userExist == null) {
      return "username not found";
    }

    TweetRepository.addNewTweet(new Tweet(userExist, tweet.getTweet()));

    return "tweet created";
  }

  public static List<Tweet> getTweetsPaginated(int page) {
    return TweetRepository.getTweetsPaginated(page);
  }

  public static List<Tweet> getUserTweets(String username) {
    User userExist = UserRepository.getUserByUsername(username);
    if (userExist == null) {
      return new ArrayList<>();
    }

    return TweetRepository.getTweetsByUsername(username);
  }
}
