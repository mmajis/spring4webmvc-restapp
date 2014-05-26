package net.majakorpi.simplemsgboard.repository;

import java.util.List;

import net.majakorpi.simplemsgboard.domain.Message;

/**
 * Storage repository for message board messages.
 * 
 */
public interface MessageBoardRepository {

	/**
	 * Get all messages stored in the repository.
	 * 
	 * @return List<Message> - List of all messages in the repository.
	 */
	List<Message> getMessages();

	/**
	 * Persist a message in the repository.
	 * 
	 * @param message
	 *            - A <code>Message</code> instance to be stored in the
	 *            repository.
	 */
	void addMessage(Message message);

}
