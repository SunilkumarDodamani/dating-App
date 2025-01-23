package com.datingApp.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datingApp.com.Entities.Message;
import com.datingApp.com.Entities.Users;
import com.datingApp.com.repository.MessageRepo;
import com.datingApp.com.repository.UserRepo;
@Service
public class MessageServices {
	@Autowired
	private MessageRepo messageRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public Message sendMessage(Long senderId,Long recieverId,String content) {
		Users sender=userRepo.findById(senderId)
				.orElseThrow(()->new RuntimeException("Sender is not found"));
		Users reciever=userRepo.findById(recieverId)
				.orElseThrow(()->new RuntimeException("Reciever is not found"));
		
		Message message=new Message();
		message.setSender(sender);
		message.setReciever(reciever);
		message.setContent(content);
		return messageRepo.save(message);
	}
	
	public List<Message> getconversation(Long userId1,Long userId2){
		Users user1=userRepo.findById(userId1)
				.orElseThrow(()->new RuntimeException("user1 is not found"));
		Users user2=userRepo.findById(userId2)
				.orElseThrow(()->new RuntimeException("user2 is not found"));
		
		return messageRepo.findBySenderAndRecieverOrRecieverAndSenderOrderByTime(user1, user2, user1, user2);
				
	}
	public List<Message> getUnreadMessages(Long userId){
		Users reciever=userRepo.findById(userId)
				.orElseThrow(()->new RuntimeException("Reciever is not found"));
		return messageRepo.findByRecieverAndIsReadFalse(reciever);
	}
	public void markMessagesRead(Long userId,Long senderId) {
		List<Message> messages=getconversation(userId, senderId);
		messages.forEach(message->{
			if(!message.isRead() && message.getReciever().getId().equals(userId)) {
				message.setRead(true);
			}
		});
		messageRepo.saveAll(messages);
	}
}
