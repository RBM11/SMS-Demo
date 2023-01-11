package com.ssms.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@ComponentScan(basePackages  = "com.ssms.*")
@SpringBootApplication
public class SmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}	
	
	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("SSMS API")
	              .description("Smart Store Managemenet System")
	              .version("1.0.0")
	              .license(new License().name("SSMS ").url("sms.licence.com")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Smart Store Managemenet System")
	              .url("sms.licence.com"));
	  }

}
