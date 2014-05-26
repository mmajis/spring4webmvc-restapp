package net.majakorpi.simplemsgboard.rest.resources;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messages")
public class MessageResourceListV2 {
	
	private List<MessageResourceV2> messages;

	public MessageResourceListV2() {
		super();
	}
	
	public MessageResourceListV2(List<MessageResourceV2> messages) {
		super();
		this.messages = messages;
	}

	@XmlElement(name = "message")
	public List<MessageResourceV2> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageResourceV2> messages) {
		this.messages = messages;
	}
	
}
