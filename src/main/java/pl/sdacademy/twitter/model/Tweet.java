package pl.sdacademy.twitter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Objects;

@NamedQuery(name = "Tweet.allList", query = "SELECT t FROM Tweet t")
@Entity
public class Tweet {

	@Id
	@GeneratedValue
	private int id;
	private String message;

	public Tweet() {
	}

	public Tweet(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public Tweet(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tweet tweet = (Tweet) o;
		return id == tweet.id &&
				Objects.equals(message, tweet.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, message);
	}
}
