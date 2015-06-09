package pl.edu.ug.inf.controller;


import pl.edu.ug.inf.pojo.Tweet;
import pl.edu.ug.inf.service.TwitterService;
import pl.edu.ug.inf.service.TwitterServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tweets")
public class TwitterMiningRestCtrl {

    private TwitterService twitterService = new TwitterServiceImpl();

    @GET
    @Path("/fetch")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweet> getDefaultTweet(){
        return twitterService.tweetsSentiment(twitterService.fetchTweets());
    }

    @GET
    @Path("/load")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweet> loadTweetsFromFile(){
        return twitterService.tweetsSentiment(twitterService.loadTweets());
    }

}
