package pl.sdacademy.tweeter.db.executor;

import pl.sdacademy.tweeter.model.Author;
import pl.sdacademy.tweeter.model.AuthorRepository;
import pl.sdacademy.tweeter.model.TweeterRepositoryException;

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
        try {
            entityManager.persist(author);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new TweeterRepositoryException("Transaction failed.");
        };
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