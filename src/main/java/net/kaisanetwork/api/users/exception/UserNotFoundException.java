package net.kaisanetwork.api.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private String data;

	public UserNotFoundException() {
		super("User Not Found");
	}

	public UserNotFoundException(String data) {
		super("User " + data + " Not Found");
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
