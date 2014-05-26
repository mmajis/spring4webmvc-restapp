package net.majakorpi.simplemsgboard.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.majakorpi.simplemsgboard.domain.Message;
import net.majakorpi.simplemsgboard.rest.resources.MessageResourceListV2;
import net.majakorpi.simplemsgboard.rest.resources.MessageResourceV2;
import net.majakorpi.simplemsgboard.service.MessageBoardService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BindingResult;

public class MessageControllerTest {

	private static final String URL = "http://www.nitorcreations.com";

	private static final String SENDER = "sender";

	private static final String CONTENT = "content";

	private static final String TITLE = "title";

	MessageController controller;
	
	HttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
	
	@Mock
	MessageBoardService mockService;
	
	@Mock BindingResult mockBindingResult;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new MessageController(mockService);
	}
	
	@Test
	public void shouldInsertMessage()  {
		ResponseEntity<Void> response = controller.createMessage(getGoodMessageResourceV2(), mockBindingOK());
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		verify(mockService).addMessage(any(Message.class));
	}
	
	@Test
	public void shouldReturnBadRequestDueToBindingErrors() {
		ResponseEntity<Void> response = controller.createMessage(getGoodMessageResourceV2(), mockBindingErrors());
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		verifyZeroInteractions(mockService);
	}

	@Test
	public void shouldReturnMessageResource() {
		List<Message> messages = new ArrayList<Message>();
		messages.add(getGoodMessage());
		when(mockService.getMessages()).thenReturn(messages);
		
		
		ResponseEntity<MessageResourceListV2> msgs = controller.listMessagesV2();
		
		verify(mockService).getMessages();
		assertEquals(1, msgs.getBody().getMessages().size());
		MessageResourceV2 mv2 = msgs.getBody().getMessages().get(0);
		assertEquals(TITLE, mv2.getTitle());
		assertEquals(CONTENT, mv2.getContent());
		assertEquals(SENDER, mv2.getSender());
		assertEquals(URL, mv2.getUrl());
	}

	private MessageResourceV2 getGoodMessageResourceV2() {
		return new MessageResourceV2(TITLE, CONTENT, SENDER, URL);
	}
	private Message getGoodMessage() {
		return new Message(TITLE, CONTENT, SENDER, URL);
	}

	private BindingResult mockBindingErrors() {
		BindingResult mockBindingResult = mock(BindingResult.class);
		when(mockBindingResult.hasErrors()).thenReturn(true);
		this.mockBindingResult = mockBindingResult;
		return mockBindingResult;
	}
	
	private BindingResult mockBindingOK() {
		BindingResult mockBindingResult = mock(BindingResult.class);
		when(mockBindingResult.hasErrors()).thenReturn(false);
		this.mockBindingResult = mockBindingResult;
		return mockBindingResult;
	}
}
