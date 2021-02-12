package com.game.player.one.kafka.impl;

import com.game.kafka.model.GameEvent;
import com.game.kafka.publisher.EventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

  @Autowired private final EventPublisher eventPublisher;

  @KafkaListener(
      topics = "${kafka.receiveTopicName}",
      groupId = "${kafka.groupId}",
      containerFactory = "gameEventConcurrentKafkaListenerContainerFactory")
  public void listenMessage(GameEvent gameEvent) {
    log.info("Received Message in group : {}", gameEvent);

    var isFinished = gameEvent.getIsFinished();
    var pass = gameEvent.getPass();

    if (isFinished) {
      log.info("PLAYER ONE YOU HAVE LOST THE GAME");
      eventPublisher.flush();
    } else {
      if (pass == 1) {
        log.info("PLAYER ONE YOU HAVE WON THE GAME");
        eventPublisher.publishEvent(new GameEvent(true, 0));
        eventPublisher.flush();
      } else if (pass < 0) {
        log.error("Something went wrong exiting now");
        eventPublisher.flush();
      } else {
        Integer next = Long.valueOf(Math.round(((double) pass) / 3)).intValue();
        log.info("PLAYER ONE SENDING NEXT NUM {}", next);
        eventPublisher.publishEvent(new GameEvent(false, next));
      }
    }
  }
}
