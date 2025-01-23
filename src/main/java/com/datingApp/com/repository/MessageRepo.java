package com.datingApp.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datingApp.com.Entities.Message;
import com.datingApp.com.Entities.Users;
@Repository
public interface MessageRepo  extends JpaRepository<Message, Long>{
	//fetch conversation 
	List<Message> findBySenderAndRecieverOrRecieverAndSenderOrderByTime(
		Users sender,Users reciever,Users recieverReverse,Users senderReverse	);
	
	//fetch unread messages
	List<Message> findByRecieverAndIsReadFalse(Users reciever);
}
