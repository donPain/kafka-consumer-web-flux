package com.dagobah.apimonitoringequipment.router;

import com.dagobah.apimonitoringequipment.model.Kijo;
import com.dagobah.apimonitoringequipment.service.KijoService;
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
        String equipmentId = request.pathVariable("equipmentId");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(kijoService.streamKijo(clientId, equipmentId), Kijo.class);
    }
}
