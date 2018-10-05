package pl.sdacademy.twitter.db;

import pl.sdacademy.twitter.model.Author;
import pl.sdacademy.twitter.model.AuthorRepository;
import pl.sdacademy.twitter.model.TweeterRepositoryException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;
import java.util.stream.Stream;

public class JpaAuthorRepository implements AuthorRepository {

    private EntityManager entityManager;

    public JpaAuthorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Author author) throws TweeterRepositoryException {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // if detached
        //  -> merge
        // if transient -> persist
        entityManager.persist(author);
        transaction.commit();
    }

    @Override
    public Optional<Author> findByName(String author) {
        return Optional.empty();
    }


    @Override
    public Stream<Author> findAll() throws TweeterRepositoryException {

        return entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultStream();

    }
}