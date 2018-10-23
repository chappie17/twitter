package pl.sdacademy.tweeter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sdacademy.tweeter.model.Dashboard;
import pl.sdacademy.tweeter.model.Tweet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DashboardTest {

    private Dashboard dashboard;

    @BeforeEach
    void beforeEach() throws Exception {
        //DataSource dataSource = DataSourceFactory.createDataSource();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = factory.createEntityManager();

        //new ClasspathSqlScriptExecutor(dataSource).execute
        //		("db/web-0.sql");
        dashboard = new Dashboard(entityManager);
    }

    @DisplayName("author should be able to create a new tweet")
    @Test
    void test0() throws Exception {
        // given
        String msg = "content";

        // when
        Tweet tweet = dashboard.create(msg, "any user");

        // then

        assertThat(tweet.getMessage()).isEqualTo(msg);
    }

    @DisplayName("should load created tweet from the dashboard")
    @Test
    void test1() throws Exception {
        // given
        String msg = "content";
        Tweet tweet = dashboard.create(msg, "any user");

        // when
        Stream<Tweet> allTweets = dashboard.load();

        // then
        assertThat(allTweets).containsExactlyInAnyOrder(tweet);
    }
}
