package net.majakorpi.simplemsgboard.rest.resources;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class MessageResourceV1 {
	
	@NotNull(message = "Title must be provided")
	@Length(max = 100, message = "Maximum title length is 100")
	private String title; 
	@NotNull(message = "Content must be provided")
	@Length(max = 4000, message = "Maximum content length is 4000")
	private String content;
	@NotNull
	@Length(max = 100, message = "Maximum sender length is 100")
	private String sender;

	public MessageResourceV1() {
		super();
	}
	
	public MessageResourceV1(String title, String content, String sender) {
		super();
		this.title = title;
		this.content = content;
		this.sender = sender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	

}
