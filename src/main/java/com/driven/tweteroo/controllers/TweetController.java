package com.driven.tweteroo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.driven.tweteroo.dto.TweetRequest;
import com.driven.tweteroo.models.Tweet;
import com.driven.tweteroo.services.TweetService;

@RestController
@RequestMapping("/api/tweets")
@CrossOrigin
public class TweetController {

  @PostMapping
  public String createTweet(@RequestBody TweetRequest body) {
    return TweetService.addNewTweet(body);
  }

  @GetMapping
  public List<Tweet> getTweetsPaginated(@RequestParam int page) {
    return TweetService.getTweetsPaginated(page);
  }

  @GetMapping("/{username}")
  public List<Tweet> getUserTweets(@PathVariable("username") String username) {
    return TweetService.getUserTweets(username);
  }
}
