package pl.sdacademy.tweeter.model;

import pl.sdacademy.tweeter.db.executor.JpaAuthorRepository;

public class LoginManager {

    private JpaAuthorRepository jpaAuthorRepository;

    public LoginManager(JpaAuthorRepository jpaAuthorRepository) {
        this.jpaAuthorRepository = jpaAuthorRepository;
    }

    public boolean isValid(String username, String password) {
        return jpaAuthorRepository.findAll()
                .anyMatch(author ->
                        author.getName().equals(username) && author.getPassword().equals(password));
    }
}
