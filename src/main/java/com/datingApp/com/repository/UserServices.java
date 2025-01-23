package com.datingApp.com.repository;

import java.util.List;
import java.util.Optional;

import com.datingApp.com.Entities.Users;

public interface UserServices {
	public  Users createUsers (Users users);
	public Optional<Users> getUsers(long id);
	public List<Users> getAllusers();
	public List<Users> findBYMatches(Long userId,int limit);
	
}
