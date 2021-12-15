package com.dagobah.equipmentmonitoringapi.service;

import com.dagobah.equipmentmonitoringapi.model.EquipmentStatus;
import com.dagobah.equipmentmonitoringapi.repository.EquipmentStatusRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.BufferOverflowStrategy;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.KafkaReceiver;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class EquipmentStatusService {

        Flux<EquipmentStatus> equipmentStatusStream;

        KafkaReceiver<String, EquipmentStatus> kafkaEquipmentReceiver;

    @Autowired
        public EquipmentStatusService(KafkaReceiver<String, EquipmentStatus> kafkaEquipmentReceiver) {
            this.kafkaEquipmentReceiver = kafkaEquipmentReceiver;
        }

        @PostConstruct
        public void init() {
            equipmentStatusStream = kafkaEquipmentReceiver.receive()
                    .publish()
                    .autoConnect(1)
                    .onBackpressureBuffer(5000, BufferOverflowStrategy.DROP_OLDEST)
                    .map(ConsumerRecord::value);

        }

        public Flux<EquipmentStatus> streamEquipmentStatus(String owner, String equipment){
            return equipmentStatusStream.filter(equipmentStatus -> equipmentStatus.getOwner().equals(owner) && equipmentStatus.getEquipment().equals(equipment));
        }

    }