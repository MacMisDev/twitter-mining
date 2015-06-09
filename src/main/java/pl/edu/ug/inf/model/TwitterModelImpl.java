package pl.edu.ug.inf.model;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.edu.ug.inf.pojo.Tweet;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class TwitterModelImpl implements TwitterModel{

    public List<Tweet> fetchTweetsFromApi(int numberOfTweets, String hashtags) {

        return getTweets(numberOfTweets, hashtags);
    }

    public List<Tweet> getTweets(int numberOfTweets, String hashtags){

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("PghhOtkwcOPmMjnUPzeeURc5Q")
                .setOAuthConsumerSecret("U1Ns8Ynb0ad7L0QUO5pjgejJdX6Aa7RVGed2NIfv68mS2JO4XR")
                .setOAuthAccessToken("2543100265-e3NrxLBUJoW8qdWYSnl8tWpMvVU0vG1vT0uxIAz")
                .setOAuthAccessTokenSecret("MpM1zEiSJKx8oNzCf8JKoIXRMDojkAqs73hkXhSog4ih9");

        Twitter twitterInstance = new TwitterFactory(cb.build()).getInstance();
        long lastID = Long.MAX_VALUE;
        Query query = new Query( hashtags );
        query.setLang("en");
        List<Tweet> tweetsToReturn = new ArrayList<Tweet>();
        Tweet tweet;

        while (tweetsToReturn.size() < numberOfTweets) {
            if (numberOfTweets - tweetsToReturn.size() > 100){
                query.setCount(100);
            }
            else{
                query.setCount(numberOfTweets - tweetsToReturn.size());
            }

            try {
                QueryResult result = twitterInstance.search(query);

                for (Status t : result.getTweets()){
                    if (t.getId() < lastID){
                        lastID = t.getId();
                    }

                    if(!t.getUser().getScreenName().equals("News18ru") && !t.isRetweet() && !t.getText().contains("crisis is PROOF")){
                        tweet = new Tweet(t.getId(), t.getText(), t.getUser().getName(), t.getUser().getScreenName(), t.getCreatedAt().toString());
                        tweetsToReturn.add(tweet);
                    }


                }
            }catch (TwitterException e) {
                System.out.println("Couldn't connect: " + e.toString());
            }
            query.setMaxId(lastID-1);
        }

        return tweetsToReturn;
    }

    public List<Tweet> loadTweetsFromFile(){
        ObjectMapper om = new ObjectMapper();
        List<Tweet> tweets = new ArrayList<Tweet>();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("tweets.json");
            tweets = om.readValue(is, new TypeReference<List<Tweet>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tweets;
    }

}
