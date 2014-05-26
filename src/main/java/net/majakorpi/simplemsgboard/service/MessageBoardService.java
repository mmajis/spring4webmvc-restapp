package net.majakorpi.simplemsgboard.service;

import java.util.List;

import net.majakorpi.simplemsgboard.domain.Message;

/**
 * A simple message board.
 * <p>
 * Messages can be added to the board and existing messages can be listed.
 */
public interface MessageBoardService {

	/**
	 * Get a list of messages currently on the board.
	 * 
	 * @return List<Message> - List of messages currently on the board.
	 */
	List<Message> getMessages();

	/**
	 * Adds a message to the message board.
	 * 
	 * @param message
	 *            - A <code>Message</code> instance to be added to the board.
	 */
	void addMessage(Message message);

}
