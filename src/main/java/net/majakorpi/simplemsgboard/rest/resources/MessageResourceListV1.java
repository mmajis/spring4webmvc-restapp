package net.majakorpi.simplemsgboard.rest.resources;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messages")
public class MessageResourceListV1 {
	
	private List<MessageResourceV1> messages;

	public MessageResourceListV1() {
		super();
	}
	
	public MessageResourceListV1(List<MessageResourceV1> messages) {
		super();
		this.messages = messages;
	}

	@XmlElement(name = "message")
	public List<MessageResourceV1> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageResourceV1> messages) {
		this.messages = messages;
	}
	
}
