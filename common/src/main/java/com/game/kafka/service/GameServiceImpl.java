package com.game.kafka.service;

import com.game.kafka.model.GameEvent;
import com.game.kafka.model.Player;
import com.game.kafka.publisher.EventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

  private final EventPublisher eventPublisher;
  private final Player player;

  @KafkaListener(
      topics = "${kafka.receiveTopicName}",
      groupId = "${kafka.groupId}",
      containerFactory = "gameEventConcurrentKafkaListenerContainerFactory")
  public void listenMessage(GameEvent gameEvent) {
    log.info("Received Message in group : {}", gameEvent);

    var isFinished = gameEvent.getIsFinished();
    var pass = gameEvent.getPass();

    if (isFinished) {
      log.info("PLAYER {} YOU HAVE LOST THE GAME", player.getName());
      eventPublisher.flush();
    } else {
      if (pass == 1) {
        log.info("PLAYER {} YOU HAVE WON THE GAME", player.getName());
        eventPublisher.publishEvent(new GameEvent(true, 0));
        eventPublisher.flush();
      } else if (pass < 0) {
        log.error("Something went wrong exiting now");
        eventPublisher.flush();
      } else {
        Integer next = Long.valueOf(Math.round(((double) pass) / 3)).intValue();
        log.info("PLAYER {} SENDING NEXT NUM {}", player.getName(), next);
        eventPublisher.publishEvent(new GameEvent(false, next));
      }
    }
  }
}
