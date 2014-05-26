package net.majakorpi.simplemsgboard.rest.util;

import java.util.ArrayList;
import java.util.List;

import net.majakorpi.simplemsgboard.domain.Message;
import net.majakorpi.simplemsgboard.rest.resources.MessageResourceV1;
import net.majakorpi.simplemsgboard.rest.resources.MessageResourceV2;

public class ResourceConverter {

	public static List<MessageResourceV1> convertV1(List<Message> messages) {
		List<MessageResourceV1> convertedList = new ArrayList<MessageResourceV1>();
		for (Message m : messages) {
			convertedList.add(new MessageResourceV1(m.getTitle(), m
					.getContent(), m.getSender()));
		}
		return convertedList;
	}

	public static List<MessageResourceV2> convertV2(List<Message> messages) {
		List<MessageResourceV2> convertedList = new ArrayList<MessageResourceV2>();
		for (Message m : messages) {
			convertedList.add(new MessageResourceV2(m.getTitle(), m
					.getContent(), m.getSender(), m.getUrl().toString()));
		}
		return convertedList;
	}

	public static MessageResourceV1 convertV1(Message message) {
		return new MessageResourceV1(message.getTitle(), message.getContent(),
				message.getSender());
	}

	public static MessageResourceV2 convertV2(Message message) {
		return new MessageResourceV2(message.getTitle(), message.getContent(),
				message.getSender(), message.getUrl().toString());
	}
	
	public static Message convertMessage(MessageResourceV2 mrv2) {
		return new Message(mrv2.getTitle(), mrv2.getContent(), mrv2.getSender(), mrv2.getUrl());
	}

}
