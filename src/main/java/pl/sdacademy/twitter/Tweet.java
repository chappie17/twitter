package pl.sdacademy.twitter;

public class Tweet {
	private int id;
	private String message;
	private String author;

	public Tweet(String message) {
		this.message = message;
	}

	public Tweet(String message, String author) {
		this.author = author;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getAuthor() {
		return author;
	}

	public Tweet(int id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Tweet{" + "id=" + id + ", message='" + message + '\'' + ", author='" + author + '\'' + '}';
	}
}
