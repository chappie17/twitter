package pl.sdacademy.twitter.model;

import java.util.stream.Stream;

public class Dashboard {

    TweetRepository repository;

    public Dashboard(TweetRepository repository) {
        this.repository = repository;
    }

    public Tweet create(String msg, String author) throws TweetRepositoryException {
        Tweet newTweet = new Tweet(msg, author);
        try {
            repository.add(newTweet);
        } catch (TweetRepositoryException e) {
            throw new TweetRepositoryException("Fail with add tweet to the list", e);
        }
        return newTweet;
    }

    public Stream<Tweet> load() throws TweetRepositoryException {
        return repository.findTweets();
    }


}
