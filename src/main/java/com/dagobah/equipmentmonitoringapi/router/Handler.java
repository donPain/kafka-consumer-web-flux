package com.dagobah.equipmentmonitoringapi.router;

import com.dagobah.equipmentmonitoringapi.repository.EquipmentStatusRepository;
import com.dagobah.equipmentmonitoringapi.model.EquipmentStatus;
import com.dagobah.equipmentmonitoringapi.model.Kijo;
import com.dagobah.equipmentmonitoringapi.service.EquipmentStatusService;
import com.dagobah.equipmentmonitoringapi.service.KijoService;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Media;
import java.util.List;

@Component
public class Handler {

    @Autowired
    private KijoService kijoService;

    @Autowired
    private EquipmentStatusService equipmentStatusService;

    private final EquipmentStatusRepository equipmentStatusRepository;

    public Mono<ServerResponse>streamEquipmentStatus(ServerRequest request){
        String owner = request.pathVariable("owner");
        String equipment = request.pathVariable("equipment");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(equipmentStatusService.streamEquipmentStatus(owner, equipment), EquipmentStatus.class);
    }

    @Autowired
    public Handler(EquipmentStatusRepository equipmentStatusRepository) {
        this.equipmentStatusRepository = equipmentStatusRepository;
    }

    public Mono<ServerResponse>streamKijo(ServerRequest request){
        String owner = request.pathVariable("owner");
        String equipment = request.pathVariable("equipment");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(kijoService.streamKijo(owner, equipment), Kijo.class);
    }

    public Mono<ServerResponse> getEquipmentStatusByOwner(ServerRequest request){
        String owner = request.pathVariable("owner");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(equipmentStatusRepository.findByClientId(owner));
//        ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(equipmentStatusRepository.findAll(),EquipmentStatus.class);
    }
}
