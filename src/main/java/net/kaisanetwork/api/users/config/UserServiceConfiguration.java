package net.kaisanetwork.api.users.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages={"net.kaisanetwork.api"})
@Import(SwaggerConfiguration.class)
public class UserServiceConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceConfiguration.class, args);
	}

}
