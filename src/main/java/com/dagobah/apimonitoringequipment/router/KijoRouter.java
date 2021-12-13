package com.dagobah.apimonitoringequipment.router;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class KijoRouter {

        /**
         * The router configuration for the kijo handler.
         * @param kijoHandler
         * @return
         */
@Bean
        public RouterFunction<?> kijoRoute(KijoHandler kijoHandler){
        return RouterFunctions
                .route(GET("/getKijo/{clientId}/{equipmentId}"),kijoHandler::streamKijo);
}

}
