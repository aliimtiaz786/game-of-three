package com.game.kafka.publisher;

import com.game.kafka.config.KafkaGeneralConfig;
import com.game.kafka.model.GameEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class EventPublisher {

  @Autowired private final KafkaGeneralConfig kafkaGeneralConfig;

  @Autowired private final KafkaTemplate<String, GameEvent> gameEventKafkaTemplate;

  public void publishEvent(GameEvent event) {
    log.info("Sending event : {}", event);
    gameEventKafkaTemplate.send(kafkaGeneralConfig.getSendTopicName(), event);
  }

  public void flush() {
    log.info("FLUSHING QUEUE");
    gameEventKafkaTemplate.flush();
  }
}
