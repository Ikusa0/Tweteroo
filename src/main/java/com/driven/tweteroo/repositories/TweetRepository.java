package com.driven.tweteroo.repositories;

import java.util.ArrayList;
import java.util.List;

import com.driven.tweteroo.db.FakeDB;
import com.driven.tweteroo.models.Tweet;

public class TweetRepository {
  private TweetRepository() {
  }

  public static void addNewTweet(Tweet newTweet) {
    FakeDB.Tweets.add(newTweet);
  }

  public static List<Tweet> getTweetsByUsername(String username) {
    List<Tweet> dbTweets = FakeDB.Tweets.get();
    List<Tweet> userTweets = new ArrayList<>();

    for (Tweet tweet : dbTweets) {
      if (tweet.getUser().getUsername().equals(username)) {
        userTweets.add(tweet);
      }
    }

    return userTweets;
  }

  public static List<Tweet> getTweetsPaginated(int page) {
    List<Tweet> dbTweets = FakeDB.Tweets.get();
    List<Tweet> pageTweets = new ArrayList<>();
    int lastTweet = (page + 1) * 5;
    int firstTweet = lastTweet - 5;

    for (int i = firstTweet; i < Math.min(dbTweets.size(), lastTweet); i++) {
      pageTweets.add(dbTweets.get(i));
    }

    return pageTweets;
  }
}
