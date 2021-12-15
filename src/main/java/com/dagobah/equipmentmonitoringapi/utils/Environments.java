package com.dagobah.equipmentmonitoringapi.utils;

import java.util.Optional;

public class Environments {

    private static String  KAFKA_BOOTSTRAP_SERVER  =  System.getenv("KAFKA_BOOTSTRAP_SERVER");
    private static String  KAFKA_KIJO_CONSUMER_ID  =  System.getenv("KAFKA_KIJO_CONSUMER_ID");
    private static String  KAFKA_KIJO_CONSUMER_GROUP  =  System.getenv("KAFKA_KIJO_CONSUMER_GROUP");
    private static String  KAFKA_EQUIPMENT_STATUS_CONSUMER_ID  =  System.getenv("KAFKA_EQUIPMENT_STATUS_CONSUMER_ID");
    private static String  KAFKA_EQUIPMENT_STATUS_CONSUMER_GROUP  =  System.getenv("KAFKA_EQUIPMENT_STATUS_CONSUMER_GROUP");

    private static String  AUTH_URL  =  System.getenv("AUTH_URL");
    private static String  EQUIPMENT  =  System.getenv("EQUIPMENT");

    public static String getKafkaBootstrapServer() {
        return Optional.ofNullable(KAFKA_BOOTSTRAP_SERVER)
                .orElse("localhost:9092");
    }

    public static String getKafkaKijoConsumerId() {
        return Optional.ofNullable(KAFKA_KIJO_CONSUMER_ID).orElse("api-monitoring-kafka-kijo-comsumer-id-dev-1");
    }

    public static String getKafkaKijoConsumerGroup() {
        return Optional.ofNullable(KAFKA_KIJO_CONSUMER_GROUP).orElse("api-monitoring-kafka-kijo-comsumer-group-dev-1");
    }

    public static String getKafkaEquipmentStatusConsumerId() {
        return Optional.ofNullable(KAFKA_EQUIPMENT_STATUS_CONSUMER_ID).orElse("api-monitoring-kafka-equip-status-id-dev-1");
    }

    public static String getKafkaEquipmentStatusConsumerGroup() {
        return Optional.ofNullable(KAFKA_EQUIPMENT_STATUS_CONSUMER_GROUP).orElse("api-monitoring-kafka-status-consumer-id-dev-1");
    }

    public static String getAuthUrl() {
        return Optional.ofNullable(AUTH_URL)
                .orElse("https://auth-api.saas-solinftec.com/v2/auth-sgpa/");
    }

    public static String getEQUIPMENT() {
        return Optional.ofNullable(EQUIPMENT)
                .orElse("1234");
    }
}
