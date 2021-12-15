package com.dagobah.equipmentmonitoringapi.config;

import com.dagobah.equipmentmonitoringapi.utils.Environments;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.internals.ConsumerFactory;
import reactor.kafka.receiver.internals.DefaultKafkaReceiver;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaReceiverConfig {


    private static final String EQUIPMENT_STATUS_TOPIC = "EQUIPMENT_STATUS";
    private static final String KIJO_STREAM_TOPIC = "SRC_KIJO";
    private static final String BOOTSTRAP_SERVERS = Environments.getKafkaBootstrapServer();
    private static final String KIJO_CLIENT_ID_CONFIG = Environments.getKafkaKijoConsumerId();
    private static final String KIJO_GROUP_ID_CONFIG = Environments.getKafkaKijoConsumerGroup();
    private static final String EQUIPMENT_STATUS_CLIENT_ID_CONFIG = Environments.getKafkaEquipmentStatusConsumerId();
    private static final String EQUIPMENT_STATUS_GROUP_ID_CONFIG = Environments.getKafkaEquipmentStatusConsumerGroup();


    @Bean
    public KafkaReceiver kafkaReceiver(){

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, KIJO_CLIENT_ID_CONFIG);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KIJO_GROUP_ID_CONFIG);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(JsonDeserializer.TYPE_MAPPINGS, "Kijo:com.dagobah.equipmentmonitoringapi.model.Kijo");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        return new DefaultKafkaReceiver(ConsumerFactory.INSTANCE, ReceiverOptions.create(props).subscription(Collections.singletonList(KIJO_STREAM_TOPIC)));
    }

    @Bean
    public KafkaReceiver kafkaEquipmentReceiver(){

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, EQUIPMENT_STATUS_CLIENT_ID_CONFIG);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, EQUIPMENT_STATUS_GROUP_ID_CONFIG);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(JsonDeserializer.TYPE_MAPPINGS, "EquipmentStatus:com.dagobah.apimonitoringequipment.model.EquipmentStatus");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        return new DefaultKafkaReceiver(ConsumerFactory.INSTANCE, ReceiverOptions.create(props).subscription(Collections.singletonList(EQUIPMENT_STATUS_TOPIC)));
    }
}
