package com.datingApp.com.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private  String name;
	
	private String gender;
	
	private int	age;
	
	private List<String> interests;
}
