package net.kaisanetwork.api.users.integration;

import java.util.List;

import net.kaisanetwork.api.users.dto.User;
import net.kaisanetwork.api.users.exception.UserAlreadyExistsException;
import net.kaisanetwork.api.users.exception.UserNotFoundException;

public interface UserRepository {

	public List<User> getAll();
	public User findUser(String email) throws UserNotFoundException;
	public void saveUser(User newUser) throws UserAlreadyExistsException;

}
