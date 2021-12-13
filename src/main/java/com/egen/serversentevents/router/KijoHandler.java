package com.egen.serversentevents.router;

import com.egen.serversentevents.model.Kijo;
import com.egen.serversentevents.service.KijoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class KijoHandler {

    @Autowired
    private KijoService kijoService;

    public Mono<ServerResponse>streamKijo(ServerRequest request){
        String clientId = request.pathVariable("clientId");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(kijoService.streamKijo(clientId), Kijo.class);
    }
}
