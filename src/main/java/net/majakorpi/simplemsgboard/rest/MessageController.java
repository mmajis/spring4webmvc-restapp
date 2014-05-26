package net.majakorpi.simplemsgboard.rest;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.majakorpi.simplemsgboard.rest.resources.MessageResourceListV1;
import net.majakorpi.simplemsgboard.rest.resources.MessageResourceListV2;
import net.majakorpi.simplemsgboard.rest.resources.MessageResourceV1;
import net.majakorpi.simplemsgboard.rest.resources.MessageResourceV2;
import net.majakorpi.simplemsgboard.rest.util.ResourceConverter;
import net.majakorpi.simplemsgboard.service.MessageBoardService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/messages")
public class MessageController {

	private final MessageBoardService service;

	@Inject
	public MessageController(MessageBoardService service) {
		super();
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET, produces = { "application/vnd.simplemsgboard.v1+json" })
	public ResponseEntity<MessageResourceListV1> listMessages(
			HttpServletRequest request) {
		if (request.getParameterMap().values().size() > 0) {
			return new ResponseEntity<MessageResourceListV1>(
					HttpStatus.BAD_REQUEST);
		}
		List<MessageResourceV1> resources = ResourceConverter.convertV1(service
				.getMessages());
		MessageResourceListV1 resourceList = new MessageResourceListV1(resources);
		HttpStatus status = resources.isEmpty() ? HttpStatus.NO_CONTENT
				: HttpStatus.OK;
		return new ResponseEntity<MessageResourceListV1>(resourceList, status);
	}

	@RequestMapping(method = RequestMethod.GET, produces = {
			"application/vnd.simplemsgboard.v2+xml",
			"application/vnd.simplemsgboard.v2+json"})
	public ResponseEntity<MessageResourceListV2> listMessagesV2() {
		List<MessageResourceV2> resources = ResourceConverter.convertV2(service
				.getMessages());
		MessageResourceListV2 resourceList = new MessageResourceListV2(resources);
		HttpStatus status = resources.isEmpty() ? HttpStatus.NO_CONTENT
				: HttpStatus.OK;
		return new ResponseEntity<MessageResourceListV2>(resourceList, status);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = { "application/vnd.simplemsgboard.v2+json" })
	public ResponseEntity<Void> createMessage(
			@RequestBody @Valid MessageResourceV2 message,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		service.addMessage(ResourceConverter.convertMessage(message));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
