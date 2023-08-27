package com.academix_gateway;


import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {


    //basically this function forwards url to http:httpbin.org:80 and also before forwarding it sets header and then forwards
    //so basically whenerver users hits http:localhost:8765/get its sets headers and forwards request to http bin uri
//    @Bean
//    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
//        Function<PredicateSpec, Buildable<Route>> routeFunction = p->p.path("/get")
//                .filters(f->f.addRequestHeader("MyHeader", "MyUri"))
//                .uri("http://httpbin.org:80");
//        return builder.routes().route(routeFunction).route(p->p.path("/currency-exchange/**").uri("lb://currency-exchange")).route(p->p.path("/currency-conversion-feign/**").uri("lb://currency-conversion")).build();
//    }

}
