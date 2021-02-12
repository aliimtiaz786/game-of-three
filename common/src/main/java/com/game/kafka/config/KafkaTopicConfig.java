package com.game.kafka.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

  @Autowired private KafkaGeneralConfig kafkaGeneralConfig;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(
        AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaGeneralConfig.getBootstrapAddress());
    return new KafkaAdmin(configs);
  }

  @Bean
  public NewTopic sendTopic() {
    return new NewTopic(kafkaGeneralConfig.getSendTopicName(), 1, (short) 1);
  }

  @Bean
  public NewTopic receiveTopic() {
    return new NewTopic(kafkaGeneralConfig.getReceiveTopicName(), 1, (short) 1);
  }
}
