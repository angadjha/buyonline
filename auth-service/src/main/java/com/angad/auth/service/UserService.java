package com.angad.auth.service;

import java.util.Optional;

import com.angad.auth.model.User;

public interface UserService {

	User createUser(User userRequest);

	Optional<User> getUser(Integer id);

}
