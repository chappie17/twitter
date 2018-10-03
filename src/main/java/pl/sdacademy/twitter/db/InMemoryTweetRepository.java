package pl.sdacademy.twitter.db;

import pl.sdacademy.twitter.model.Tweet;
import pl.sdacademy.twitter.model.TweetRepository;
import pl.sdacademy.twitter.model.TweetRepositoryException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class InMemoryTweetRepository implements TweetRepository {

    private Collection<Tweet> allTweets = new ArrayList<>();

    @Override
    public void add(Tweet tweet) throws TweetRepositoryException {
                allTweets.add(tweet);
    }

    @Override
    public Stream<Tweet> findTweets() throws TweetRepositoryException {
        return allTweets.stream();
    }
}
