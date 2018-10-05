package pl.sdacademy.twitter.db;

import pl.sdacademy.twitter.model.Author;
import pl.sdacademy.twitter.model.Tweet;
import pl.sdacademy.twitter.model.AuthorRepository;
import pl.sdacademy.twitter.model.TweeterRepositoryException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class InMemoryAuthorRepository implements AuthorRepository {

    Collection <Author> authors = new ArrayList<>();

    @Override
    public void save(Author author) {
        authors.add(author);
    }

    @Override
    public Optional<Author> findByName(String author) {
        return Optional.empty();
    }

    @Override
    public Stream<Author> findAll() {
        return null;
    }
}
