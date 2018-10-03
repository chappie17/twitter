package pl.sdacademy.twitter.model;

import java.util.stream.Stream;

public interface TweetRepository {

    void add(Tweet tweet) throws TweetRepositoryException;

    Stream<Tweet> findTweets() throws TweetRepositoryException;

}
