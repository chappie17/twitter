package pl.sdacademy.twitter.db;

import pl.sdacademy.twitter.model.Tweet;
import pl.sdacademy.twitter.model.TweetRepository;
import pl.sdacademy.twitter.model.TweetRepositoryException;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class SqlTweetRepository implements TweetRepository {

    private DataSource dataSource;

    public SqlTweetRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Tweet tweet) throws TweetRepositoryException {
        try {
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement("INSERT INTO tweet (message, author) VALUES (?,?)")) {
                statement.setString(1, tweet.getMessage());
                statement.setString(2, tweet.getAuthor());
                statement.execute();
            }
        } catch (SQLException e) {
            throw wrapEx("Fail to add tweet", e);
        }
    }

    @Override
    public Stream<Tweet> findTweets() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT "
                    + "*" + " FROM tweet");
            Collection<Tweet> allTweets = new ArrayList<>();
            while (resultSet.next()) {
                allTweets.add(new Tweet(resultSet.getString
                        ("message"), resultSet.getString
                        ("author")));
            }
            return allTweets.stream();
        } catch (SQLException e) {
            throw wrapEx("Fail with get list of tweets", e);
        }
    }

    private TweetRepositoryException wrapEx(String msg, SQLException e) {
        throw new TweetRepositoryException(msg, e);
    }
}
