package com.trucdulieu.apigateway.config;

import lombok.RequiredArgsConstructor;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
@RequiredArgsConstructor
public class GatewayConfig {

    private final AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service-route", r -> r.path("/api/v1/auth/**")
                        .filters(
                                f -> f
                                .rewritePath("/api/v1/", "/")
                                .circuitBreaker(
                                        c -> c.setName("auth").setFallbackUri("forward:/fallbacks/auth")
                                )
                                .filter(filter)
                        )
                        .uri("lb://auth-service")
                )
                .route("common-category-route", r -> r.path("/api/v1/common-category/**")
                        .filters(
                                f -> f
                                .rewritePath("/api/v1/", "/")
                                .filter(filter)
                        )
                        .uri("lb://common-category")
                )

                .build();
    }

}
