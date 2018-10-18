package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket app_api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/api/user/**")).build().groupName("用户接口").pathMapping("/")
				.apiInfo(apiInfo("用户接口", "文档中可以查询及测试接口调用参数和结果", "4.4"));
	}

	@Bean
	public Docket wap_api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/api/order/**")).build().groupName("订单接口").pathMapping("/")
				.apiInfo(apiInfo("订单接口", "文档中可以查询及测试接口调用参数和结果", "4.4"));
	}

	@Bean
	public Docket web_api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/api/goods/**")).build().groupName("商品接口").pathMapping("/")
				.apiInfo(apiInfo("商品接口", "文档中可以查询及测试接口调用参数和结果", "4.4"));
	}

	private ApiInfo apiInfo(String name, String description, String version) {
		ApiInfo apiInfo = new ApiInfoBuilder().title(name).description(description).version(version).build();
		return apiInfo;
	}

}
