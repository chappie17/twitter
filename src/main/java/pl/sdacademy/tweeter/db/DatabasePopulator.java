package pl.sdacademy.tweeter.db;

import pl.sdacademy.tweeter.db.executor.JpaAuthorRepository;
import pl.sdacademy.tweeter.model.Author;

public class DatabasePopulator {

    public static void populateDefaultAuthors() {
        JpaAuthorRepository jpaAuthorRepository = new JpaAuthorRepository(
                TwitterEntityManagerFactory.entityManager());
        jpaAuthorRepository.save(new Author("Dean", "admin0"));
        jpaAuthorRepository.save(new Author("Sammy", "admin1"));
        jpaAuthorRepository.save(new Author("Bobby", "admin2"));
    }
}
