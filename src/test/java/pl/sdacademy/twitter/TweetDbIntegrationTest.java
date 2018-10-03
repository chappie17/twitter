package pl.sdacademy.twitter;

import org.junit.jupiter.api.*;
import pl.sdacademy.twitter.model.Author;
import pl.sdacademy.twitter.model.Tweet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TweetDbIntegrationTest {

    private EntityManagerFactory factory;

    @BeforeEach
    void beforeEach(){
        factory = Persistence.createEntityManagerFactory("test");
    }

    @AfterEach
    void afterEach(){
        factory.close();
    }

    @DisplayName("should check if author can have many tweets")
    @Test
    void saveAuthor() throws Exception {
        // given
        EntityManager entityManager = factory.createEntityManager();
        Tweet tweet0 = messageTweet("my first tweet about hybernate");
        Tweet tweet1 = messageTweet("my next interesting tweet");
        Tweet tweet2 = messageTweet("goodbye!");

        Author author = authorWithTweets(tweet0, tweet1, tweet2);

    	// when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(author);
        transaction.commit();

    	// then
        Author foundAuthor = entityManager.createQuery("SELECT au FROM Author au", Author.class).getSingleResult();
        assertThat(foundAuthor.getTweets()).extracting("message")
                .containsExactlyInAnyOrder("my first tweet about hybernate","my next interesting tweet","goodbye!");

    }

    private Author authorWithTweets(Tweet... tweets) {
        Author author = new Author();
        author.setTweets(Arrays.asList(tweets));
        return author;
    }

    private Tweet messageTweet(String message) {
        Tweet tweet = new Tweet();
        tweet.setMessage(message);
        return tweet;
    }
}
