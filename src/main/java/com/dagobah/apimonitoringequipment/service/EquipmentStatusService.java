package com.dagobah.apimonitoringequipment.service;

import com.dagobah.apimonitoringequipment.model.EquipmentStatus;
import com.dagobah.apimonitoringequipment.model.Kijo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.BufferOverflowStrategy;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;

import javax.annotation.PostConstruct;

@Service
public class EquipmentStatusService {

        Flux<EquipmentStatus> equipmentStatusStream;

        final KafkaReceiver<String, EquipmentStatus> kafkaEquipmentReceiver;

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

        public Flux<EquipmentStatus> streamEquipmentStatus(String clientId, String equipmentId){
            return equipmentStatusStream.filter(equipmentStatus -> equipmentStatus.getClientId().equals(clientId) && equipmentStatus.getEquipmentId().equals(equipmentId));
        }
    }