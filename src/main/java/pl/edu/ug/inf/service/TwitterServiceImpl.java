package pl.edu.ug.inf.service;


import pl.edu.ug.inf.model.TwitterModel;
import pl.edu.ug.inf.model.TwitterModelImpl;
import pl.edu.ug.inf.naiveBayes.BayesClassifier;
import pl.edu.ug.inf.naiveBayes.Classifier;
import pl.edu.ug.inf.pojo.Tweet;

import java.util.Arrays;
import java.util.List;

public class TwitterServiceImpl implements TwitterService{


    private TwitterModel twitterModel = new TwitterModelImpl();

/*    public List<Tweet> getTweets() {
        return twitterModel.loadTweets();
    }*/

    public List<Tweet> fetchTweets() {
        String hashtags = "#war #ukraine";
        int numberOfTweets = 150;

        return twitterModel.fetchTweetsFromApi(numberOfTweets, hashtags);
    }

    public List<Tweet> tweetsSentiment(List<Tweet> tweets) {
        final Classifier<String, String> bayes = new BayesClassifier<String, String>();

        final String[] negativeWords = { "killed", "wounded", "rebel", "invasion", "cheat", "nuke", "scar","explodes", "sinks", "depress", "airstrike", "crisis", "battle", "fear", "dead", "bloodshed", "combat", "conflict", "fight", "hostile", "strike", "warfare", "weapon", "casualties", "invasion", "explode", "assault", "ambush", "kill", "murder", "attack", "bombing", "combat", "havoc", "minefield", "revenge", "" };
        final String[] positiveWords = { "talk", "accord", "peace", "defend", "surrender", "truce", "good will", "ceasefire", "kindness", "friendship", "harmony", "survive", "escape", "politic", "control", "avoid"};

        bayes.learn("positive", Arrays.asList(positiveWords));
        bayes.learn("negative", Arrays.asList(negativeWords));


        for(Tweet t : tweets){
            if(bayes.classify(Arrays.asList(t.getText().replaceAll("#", "").split("\\s"))).getCategory().equals("positive") ){
                t.setPositive(true);
            }else
                t.setPositive(false);
        }

        return tweets;
    }

    public List<Tweet> loadTweets(){
        return twitterModel.loadTweetsFromFile();
    }
}
