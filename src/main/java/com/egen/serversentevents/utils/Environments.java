package com.egen.serversentevents.utils;

import java.util.Optional;

public class Environments {

    private static String  KAFKA_BOOTSTRAP_SERVER  =  System.getenv("KAFKA_BOOTSTRAP_SERVER");
    private static String  KAFKA_COMMAND_CONSUMER_ID  =  System.getenv("KAFKA_CONSUMER_ID");
    private static String  KAFKA_COMMAND_CONSUMER_GROUP  =  System.getenv("KAFKA_CONSUMER_GROUP");
    private static String  KAFKA_COMMAND_ACK_PRODUCER_ID =  System.getenv("KAFKA_COMMAND_ACK_PRODUCER_ID");
    private static String  KAFKA_EQUIPMENT_STATUS_PRODUCER_ID  =  System.getenv("KAFKA_EQUIPMENT_STATUS_PRODUCER_ID");
    private static String  KAFKA_KIJO_PRODUCER_ID  =  System.getenv("KAFKA_EQUIPMENT_STATUS_PRODUCER_ID");
    private static String  AUTH_URL  =  System.getenv("AUTH_URL");
    private static String  EQUIPMENT  =  System.getenv("EQUIPMENT");

    public static String getKafkaBootstrapServer() {
        return Optional.ofNullable(KAFKA_BOOTSTRAP_SERVER)
                .orElse("localhost:9092");
    }

    public static String getKafkaCommandConsumerId() {
        return Optional.ofNullable(KAFKA_COMMAND_CONSUMER_ID).orElse("channel-command-comsumer-id-dev-1");
    }

    public static String getKafkaCommandConsumerGroup() {
        return Optional.ofNullable(KAFKA_COMMAND_CONSUMER_GROUP).orElse("channel-command-comsumer-group-dev-1");
    }

    public static String getKafkaCommandAckProducerId() {
        return Optional.ofNullable(KAFKA_COMMAND_ACK_PRODUCER_ID).orElse("channel-command-ACK-id-dev-1");
    }

    public static String getKafkaEquipmentStatusProducerId() {
        return Optional.ofNullable(KAFKA_EQUIPMENT_STATUS_PRODUCER_ID).orElse("channel-equip-status-producer-id-dev-1");
    }

    public static String getKafkaKijoProducerId() {
        return Optional.ofNullable(KAFKA_KIJO_PRODUCER_ID).orElse("channel-kijo-id-dev-1");
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
