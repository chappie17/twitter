package pl.sdacademy.twitter.db;

import pl.sdacademy.twitter.model.Tweet;
import pl.sdacademy.twitter.model.TweetRepository;
import pl.sdacademy.twitter.model.TweetRepositoryException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.stream.Stream;

public class JpaTweetRepository implements TweetRepository {

    private EntityManager entityManager;

    public JpaTweetRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Tweet tweet) throws TweetRepositoryException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(tweet);
        transaction.commit();
    }

    @Override
    public Stream<Tweet> findTweets() throws TweetRepositoryException {

        return entityManager.createNamedQuery("Tweet.allList", Tweet.class).getResultStream();

    }
}