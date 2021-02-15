package com.chits.pay;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ChitFundsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChitFundsAppApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.paths(PathSelectors.ant("/admin/*"))
				.apis(RequestHandlerSelectors.basePackage("com.chits.pay"))
				.build().apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		
		return new ApiInfo("ChitFundsApp", "Make Chits easy", "1.0", "free to use", 
				new springfox.documentation.service.Contact("Anand", "http:909/chits", "avr@gmail.com"),
				"Licenec", "abcd", Collections.emptyList());
		
	}

}
