/*
package vn.techmaster.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Mono;

@Component
public class Config {
  @Bean
  public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    return builder.routes()
        .route(r -> r.path("/book/**").uri("http://localhost:8081/"))
        .route(r -> r.path("/film/**").uri("http://localhost:8082/"))
        .build();
  }

  @Bean
  public KeyResolver userKeyResolver() {
    return exchange -> Mono.just("1");
  }


  @Bean
  public ServerCodecConfigurer serverCodecConfigurer() {
    return ServerCodecConfigurer.create();
  }
}
*/
