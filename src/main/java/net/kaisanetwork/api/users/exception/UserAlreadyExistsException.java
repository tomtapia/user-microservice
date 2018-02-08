package net.kaisanetwork.api.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;
	private String email;
	
	public UserAlreadyExistsException() {
		super("User Email Already Exists");
	}

	public UserAlreadyExistsException(String email) {
		super(String.format("User Email %s Already Exists", email));
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
