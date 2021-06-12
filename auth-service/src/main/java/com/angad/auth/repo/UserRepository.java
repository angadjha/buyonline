package com.angad.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angad.auth.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
