package pl.sdacademy.twitter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TweetDbIntegrationTest {

    private EntityManagerFactory factory;

    @DisplayName("should check if author can have many tweets")
    @Test
    void saveAuthor() throws Exception {
        EntityManager entityManager =
    	// given

    	// when

    	// then
    	Assertions.fail("Write your test");
    }
}
