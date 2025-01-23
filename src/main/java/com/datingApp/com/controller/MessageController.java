package com.datingApp.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datingApp.com.Entities.Message;
import com.datingApp.com.services.MessageServices;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageServices messageServices;
	
	@PostMapping("/send")
	public Message sendMessage(@RequestParam Long senderId,@RequestParam Long recieverId
			,@RequestBody String content) {
		return messageServices.sendMessage(senderId, recieverId, content);
		
		
	}
	
	@GetMapping("/conversation")
	public List<Message> getConversion(@RequestParam long userId1,@RequestParam long userId2){
		return messageServices.getconversation(userId1, userId2);
	}
	
	@GetMapping("/unread")
	public List<Message> getunreadMessages(@RequestParam Long userId){
		return messageServices.getUnreadMessages(userId);
	}
	@PutMapping("/mark-as-read")
	public void markMessageRead(@RequestParam Long userId,@RequestParam Long senderId) {
		messageServices.markMessagesRead(userId, senderId);
	}
}
