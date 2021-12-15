package com.dagobah.equipmentmonitoringapi.router;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class Router {

        /**
         * The router configuration for the kijo handler.
         * @param handler
         * @return
         */
@Bean
        public RouterFunction<?> equipmentMonitoringApiRoutes(Handler handler){
        return RouterFunctions
                .route(GET("/getKijo/{owner}/{equipment}"), handler::streamKijo)
                .andRoute(GET("/getEquipmentStatus/{owner}"), handler::getEquipmentStatusByOwner);
        }
}
