package net.kaisanetwork.api.users.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("net.kaisanetwork.api.users.service"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Users REST API", 
				"Some custom description of API.", 
				"API TOS", 
				"Terms of service",
				new Contact("Tomás Tapia", "www.kaisanetwork.net", "ttapia@kaisanetwork.net"), 
				"MIT License",
				"https://opensource.org/licenses/MIT", 
				Collections.emptyList());
	}

}
