package net.majakorpi.simplemsgboard.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.majakorpi.simplemsgboard.domain.Message;

/**
 * 
 * @see MessageBoardRepository
 */
@Repository
public class MessageBoardRepositoryMemoryImpl implements MessageBoardRepository {

	private final List<Message> messages = Collections.synchronizedList(new ArrayList<Message>());
	
	/**
	 * @see MessageBoardRepository#getMessages()
	 */
	public List<Message> getMessages() {
		List<Message> toReturn = new ArrayList<Message>();
		toReturn.addAll(messages);
		return toReturn;
	}

	/**
	 * @see MessageBoardRepository#addMessage(Message)
	 */
	public void addMessage(Message message) {
		messages.add(message);
	}

}
