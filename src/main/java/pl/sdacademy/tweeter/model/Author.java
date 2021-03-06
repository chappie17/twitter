package pl.sdacademy.tweeter.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String password;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_author")
    private Collection <Tweet> tweets;

    public Author(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Author(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Collection<Tweet> tweets) {
        this.tweets = tweets;
    }

    public Author() {
    }

    public Author(String name, Collection<Tweet> tweets) {
        this.name = name;
        this.tweets = tweets;
    }

    public Tweet addTweet(Tweet tweet) {
        return tweet;
    }


}
