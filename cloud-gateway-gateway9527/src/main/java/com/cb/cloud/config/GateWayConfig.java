package com.cb.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author cuibin
 * @date 2020-07-29 14:50
 */
@Component
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("cloud_path",
                r -> r.path("/guonei")     //此处的路径需要反斜杠
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
