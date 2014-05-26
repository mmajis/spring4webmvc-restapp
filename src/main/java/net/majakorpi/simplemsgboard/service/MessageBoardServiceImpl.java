package net.majakorpi.simplemsgboard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.majakorpi.simplemsgboard.domain.Message;
import net.majakorpi.simplemsgboard.repository.MessageBoardRepository;

/**
 * 
 * @see MessageBoardService
 */
@Service
public class MessageBoardServiceImpl implements MessageBoardService {

	private final MessageBoardRepository messageRepository;

	@Inject
	public MessageBoardServiceImpl(MessageBoardRepository messageRepository) {
		super();
		this.messageRepository = messageRepository;
	}

	/**
	 * @see MessageBoardService#getMessages()
	 */
	public List<Message> getMessages() {
		return messageRepository.getMessages();
	}

	/**
	 * @see MessageBoardService#addMessage(Message)
	 */
	public void addMessage(Message message) {
		messageRepository.addMessage(message);
	}

}
