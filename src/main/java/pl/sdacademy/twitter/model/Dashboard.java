package pl.sdacademy.twitter.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

public class Dashboard {

    EntityManager entityManager;

    public Dashboard(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Tweet create(String msg, String author) throws TweeterRepositoryException {
        Tweet tweet = new Tweet(msg);

        // begin transaction
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a WHERE a.name = :name", Author.class);
        query.setParameter("name", author);
        try {
            Author foundAuthor = query.getSingleResult();
            foundAuthor.addTweet(tweet);

        } catch (NoResultException e) {
            Author newAuthor = new Author();
            newAuthor.setTweets(Collections.singleton(tweet));
            entityManager.persist(newAuthor);
        }
        // commit transaction
        tx.commit();

        return tweet;
    }

    public Stream<Tweet> load() throws TweeterRepositoryException {
        Stream<Author> authors = entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultStream();

        Collection<Tweet> allTweets = new ArrayList<>();
        authors
                .forEach(
                        a -> allTweets.addAll(a.getTweets())
                );
        return allTweets.stream();
    }
}