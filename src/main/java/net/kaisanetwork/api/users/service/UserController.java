package net.kaisanetwork.api.users.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.kaisanetwork.api.users.dto.User;
import net.kaisanetwork.api.users.exception.UserAlreadyExistsException;
import net.kaisanetwork.api.users.integration.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@ApiOperation(value = "Get All Users from DataBase.")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> users() throws Exception {
		return userRepository.getAll();
	}

	@ApiOperation(value = "Find User by Email Address.")
	@GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User findUser(
			@ApiParam(value = "Email Address from User.", required = true) @RequestParam(name = "email", required = true) String email)
			throws Exception {
		return userRepository.findUser(email);
	}

	@ApiOperation(value = "Create a new User into DataBase.")
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody @Validated User user) throws UserAlreadyExistsException {
		userRepository.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/find")
				.queryParam("email", user.getEmail()).buildAndExpand().toUri();
		return ResponseEntity.created(location).build();
	}

}
