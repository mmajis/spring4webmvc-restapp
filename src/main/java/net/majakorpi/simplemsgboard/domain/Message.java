package net.majakorpi.simplemsgboard.domain;


/**
 * A message on the message board.
 * 
 * Instances of this class are immutable.
 */
public class Message {

	private final String title, content, sender;

	private final String url;

	public Message(String title, String content, String sender, String url) {
		super();
		this.title = title;
		this.content = content;
		this.sender = sender;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getSender() {
		return sender;
	}

	public String getUrl() {
		return url;
	}

}
