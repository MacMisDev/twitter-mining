package pl.edu.ug.inf.model;


import pl.edu.ug.inf.pojo.Tweet;

import java.util.List;

public interface TwitterModel {

    List<Tweet> fetchTweetsFromApi(int numberOfTweets, String hashtags);
    List<Tweet> loadTweetsFromFile();
}
