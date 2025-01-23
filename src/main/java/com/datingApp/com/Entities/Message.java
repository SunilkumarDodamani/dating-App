package com.datingApp.com.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Message {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="sender_id",nullable = false)
	private Users sender;
	
	@ManyToOne
	@JoinColumn(name="reciever_id" ,nullable = false)
	private Users reciever;
	
	@Column(nullable = false)
	private String content;
	
	
	private LocalDateTime time=LocalDateTime.now();
	
	private boolean isRead=false;
}
