package com.dagobah.equipmentmonitoringapi.service;

import com.dagobah.equipmentmonitoringapi.model.Kijo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.BufferOverflowStrategy;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;

import javax.annotation.PostConstruct;

@Service
public class KijoService {

    Flux<Kijo> kijoStream;

    final KafkaReceiver<String, Kijo> kafkaReceiver;

    @Autowired
    public KijoService(KafkaReceiver<String, Kijo> kafkaReceiver) {
        this.kafkaReceiver = kafkaReceiver;
    }

    @PostConstruct
    public void init() {
        kijoStream = kafkaReceiver.receive()
                .publish()
                .autoConnect(1)
                .onBackpressureBuffer(5000, BufferOverflowStrategy.DROP_OLDEST)
                .map(ConsumerRecord::value);

    }

    public Flux<Kijo> streamKijo(String owner, String equipment){
        return kijoStream.filter(kijo -> kijo.getOwner().equals(owner) && kijo.getEquipment().equals(equipment));
    }

}
