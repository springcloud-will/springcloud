package com.atme.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routers = routeLocatorBuilder.routes();

        return routers.route("path_route_atme", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
    }
}
