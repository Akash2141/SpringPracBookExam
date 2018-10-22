package com.onlinetest.OnlineTest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
public class swaggerConfig {
	
	private static final String SWAGGER_API_VERSION="1.0";
	private static final String LICENCE_TEXT="LICENCE";
	private static final String title="products Rest APi";
	private static final String description = "Restful API for Products";
	
	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.license(LICENCE_TEXT)
				.version(SWAGGER_API_VERSION)
				.build();
		
	}
	
	public Docket productAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.pathMapping("/")
				.select()
				.paths()
				.build();
	}

}
