package com.dagobah.equipmentmonitoringapi.config;

import com.dagobah.equipmentmonitoringapi.model.EquipmentStatus;
import com.dagobah.equipmentmonitoringapi.utils.Environments;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerFactoryConfig {

    @Bean
    public ConsumerFactory<String, EquipmentStatus>
    equipmentStatusConsumer()
    {
        Map<String, Object> map
                = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Environments.getKafkaBootstrapServer());

        map.put(ConsumerConfig.GROUP_ID_CONFIG, Environments.getKafkaEquipmentStatusConsumerId());
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        map.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        map.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        map.put(JsonDeserializer.TRUSTED_PACKAGES,"*");
        map.put(JsonDeserializer.TYPE_MAPPINGS,"EquipmentStatus:com.dagobah.equipmentmonitoringapi.model.EquipmentStatus");

        return new DefaultKafkaConsumerFactory<>(
                map, new StringDeserializer(),
                new JsonDeserializer<>(EquipmentStatus.class));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EquipmentStatus> equipmenStatustListen() {
        ConcurrentKafkaListenerContainerFactory<String, EquipmentStatus> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(equipmentStatusConsumer());
        return factory;
    }
}
