/**
 * 
 */
package com.angad.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angad.auth.model.User;
import com.angad.auth.repo.UserRepository;

/**
 * @author Danger Zone
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User userRequest) {
		return userRepository.save(userRequest);
	}

	@Override
	public Optional<User> getUser(Integer id) {
		return userRepository.findById(id);
	}

}
