package vn.techmaster.gateway;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.annotations.info.Info;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@SpringBootApplication
@EnableSwagger2WebFlux
@RestController
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Autowired
	RouteDefinitionLocator locator;

//	@Bean
//	public List<GroupedOpenApi> apis() {
//		List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
//		List<GroupedOpenApi> groups = definitions.stream()
//				//.filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
//				.map(routeDefinition -> {
//			//String name = routeDefinition.getId().replaceAll("-service", "");
//			String name = routeDefinition.getId();
//			return GroupedOpenApi.builder()
//					.pathsToMatch("**/" + name + "/**")
//					.setGroup(name)
//					.build();
//		}).collect(Collectors.toList());
//		return groups;
//	}
	@Bean
	GroupedOpenApi userApis() { // group all APIs with `user` in the path

		return GroupedOpenApi.builder().setGroup("book").pathsToMatch("**/book/**").build();
	}

	@Bean
	GroupedOpenApi adminApis() { // group all APIs with `admin` in the path
		return GroupedOpenApi.builder().setGroup("film").pathsToMatch("**/film/**").build();
	}


	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/book/**").uri("http://localhost:8081/"))
				.route(r -> r
						.path("/film/**")
						//.filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter()).setStatusCode(HttpStatus.TOO_MANY_REQUESTS)))
						.uri("http://localhost:8082/"))
				.build();
	}
	@RequestMapping(value = "/custom", method = RequestMethod.POST)
	public String custom() {
		return "custom";
	}
	@Bean
	public KeyResolver userKeyResolver() {
		return exchange -> Mono.just("1");
	}

	private static final Contact DEFAULT_CONTACT = new Contact(
			"Viktor Mokrecov", "https://github.com/vmokrecov", "v.mokrecov.ru@gmail.com");

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList(
			"application/json", "application/xml"));

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("My Title")
				.description("My Description")
				.version("1.0")
				.termsOfServiceUrl("urn:tos")
				.contact(DEFAULT_CONTACT)
				.license("MIT")
				.licenseUrl("https://github.com/300kks/api-service/blob/master/LICENSE")
				.build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}

	@Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
		return ServerCodecConfigurer.create();
	}

}
