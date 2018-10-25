package pl.sdacademy.tweeter.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TwitterEntityManagerFactory {
    private static EntityManagerFactory entityManagerFactory;

    public static synchronized EntityManager entityManager() {
        if (entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory("test");
        return entityManagerFactory.createEntityManager();
    }
}
