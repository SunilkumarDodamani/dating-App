package com.datingApp.com.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datingApp.com.Entities.Users;
import com.datingApp.com.repository.UserRepo;
import com.datingApp.com.repository.UserServices;

import lombok.Data;
@Service
@Data
public class UserServicesImpl implements UserServices{
	@Autowired
	private UserRepo userRepo;
	
	public Users createUsers(Users users) {
		Users user=userRepo.save(users);
		return user;
	}

	public Optional<Users> getUsers(long id) {
	return userRepo.findById(id);
	}

	@Override
	public List<Users> getAllusers() {
		List<Users> users=userRepo.findAll();
		return users;
	}

	public List<Users> findBYMatches(Long userId, int limit) {
	    Users user2 = userRepo.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    return userRepo.findAll().stream()
	            .filter(user -> !user.getGender().equals(user2.getGender())) // Opposite gender filter
	            .filter(user -> !user.getId().equals(user2.getId())) // Exclude the requesting user
	            .sorted(
	                Comparator.comparingInt((Users user) -> Math.abs(user.getAge() - user2.getAge()))
	                          .thenComparing(user -> getIntMatchCount(user, user2), Comparator.reverseOrder())
	            )
	            .limit(limit)
	            .collect(Collectors.toList());
	}

	
	private int getIntMatchCount(Users user,Users user2) {
		
		return (int) user.getInterests().stream()
				.filter(user2.getInterests()::contains)
				.count();
	}
}
