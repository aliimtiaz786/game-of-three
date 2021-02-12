package com.game.kafka.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Data
public class KafkaGeneralConfig {

  @Value(value = "${kafka.bootstrapAddress}")
  private String bootstrapAddress;

  @Value(value = "${kafka.sendTopicName}")
  private String sendTopicName;

  @Value(value = "${kafka.receiveTopicName}")
  private String receiveTopicName;

  @Value(value = "${kafka.groupId}")
  private String groupId;
}
