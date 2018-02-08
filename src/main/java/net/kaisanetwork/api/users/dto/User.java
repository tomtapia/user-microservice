package net.kaisanetwork.api.users.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "User full name.", allowEmptyValue = true, required = false)
	private String name;
	@ApiModelProperty(value = "User email address.", allowEmptyValue = false, required = true)
	@NotBlank(message = "Email value cannot be empty")
	private String email;
	@ApiModelProperty(value = "User password.", allowEmptyValue = false, required = true)
	@NotBlank(message = "Password value cannot be empty")
	private String password;
	@ApiModelProperty(value = "User created date.", allowEmptyValue = true, required = false, readOnly = true)
	private Date createdAt;
	@ApiModelProperty(value = "User last updated date.", allowEmptyValue = true, required = false, readOnly = true)
	private Date updatedAt;

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
