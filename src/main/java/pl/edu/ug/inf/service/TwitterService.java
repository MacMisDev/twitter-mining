package pl.edu.ug.inf.service;


import pl.edu.ug.inf.pojo.Tweet;

import java.util.List;

public interface TwitterService {

    List<Tweet> fetchTweets();
    List<Tweet> tweetsSentiment(List<Tweet> tweets);
    List<Tweet> loadTweets();
}
