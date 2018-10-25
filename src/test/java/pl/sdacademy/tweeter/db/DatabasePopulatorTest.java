package pl.sdacademy.tweeter.db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sdacademy.tweeter.db.executor.JpaAuthorRepository;

import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;

class DatabasePopulatorTest {

    private JpaAuthorRepository repository;

    @BeforeEach
    void before() {
        repository = new JpaAuthorRepository(Persistence.createEntityManagerFactory("test").createEntityManager());
    }

    @DisplayName("should populator create 3 authors")
    @Test
    void test() throws Exception {
        // when
        DatabasePopulator.populateDefaultAuthors();

        // then
        assertThat(repository.findAll()).hasSize(3);
    }
}