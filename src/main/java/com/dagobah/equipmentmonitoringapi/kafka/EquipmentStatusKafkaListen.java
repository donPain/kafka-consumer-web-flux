package com.dagobah.equipmentmonitoringapi.kafka;

import com.dagobah.equipmentmonitoringapi.model.EquipmentStatus;
import com.dagobah.equipmentmonitoringapi.repository.EquipmentStatusRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Component
public class EquipmentStatusKafkaListen{

    private final EquipmentStatusRepository repository;

    public EquipmentStatusKafkaListen(EquipmentStatusRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "EQUIPMENT_STATUS", containerFactory = "equipmenStatustListen")
    public void consume(@Payload EquipmentStatus equipmentStatus, MessageHeaders messageHeader){
        Long ms = Long.parseLong(Objects.requireNonNull(messageHeader.get("kafka_receivedTimestamp")).toString());
        Timestamp ts = new Timestamp(ms);
        Date since = ts;
        equipmentStatus.setSince(since.toString());
        equipmentStatus.setEquipmentStatusKey(equipmentStatus.getOwner() +"_"+ (Objects.requireNonNull(messageHeader.get("kafka_receivedMessageKey"))).toString());
        repository.save(equipmentStatus);
}



}
