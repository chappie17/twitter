package pl.sdacademy.twitter.model;

import java.util.Optional;
import java.util.stream.Stream;

public interface AuthorRepository {

    void save(Author author);

    Optional<Author> findByName(String author);

    Stream<Author> findAll();
/*    void add(Tweet tweet) throws TweeterRepositoryException;

    Stream<Tweet> findTweets() throws TweeterRepositoryException;*/

}
