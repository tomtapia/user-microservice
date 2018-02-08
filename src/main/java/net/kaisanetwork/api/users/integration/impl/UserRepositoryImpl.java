package net.kaisanetwork.api.users.integration.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kaisanetwork.api.users.dto.User;
import net.kaisanetwork.api.users.exception.UserAlreadyExistsException;
import net.kaisanetwork.api.users.exception.UserNotFoundException;
import net.kaisanetwork.api.users.integration.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private static List<User> users;

	static {
		users = new ArrayList<User>();
		User defaultUser = new User();
		defaultUser.setCreatedAt(new Date());
		defaultUser.setEmail("user@test.com");
		defaultUser.setName("User Test");
		defaultUser.setPassword("qwerty123456");
		defaultUser.setUpdatedAt(new Date());
	}

	public User findUser(String email) throws UserNotFoundException {
		for (User user : users) {
			if(email.equals(user.getEmail())) {
				return user;
			}
		}
		throw new UserNotFoundException(email);
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public void saveUser(User newUser) throws UserAlreadyExistsException {
		User repeatedUser;
		try {
			repeatedUser = this.findUser(newUser.getEmail());
		} catch (UserNotFoundException e) {
			repeatedUser = null;
		}
		if(null == repeatedUser) {
			users.add(newUser);
		} else {
			throw new UserAlreadyExistsException(newUser.getEmail());
		}
	}
}
