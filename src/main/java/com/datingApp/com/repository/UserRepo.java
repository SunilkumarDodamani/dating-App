package com.datingApp.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datingApp.com.Entities.Users;
@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

}
