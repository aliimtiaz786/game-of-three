package com.game.player.one;

import com.game.kafka.model.GameEvent;
import com.game.kafka.publisher.EventPublisher;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GameStartController {

  private static final Random random = new Random();
  private static final int MAX = 10000;

  @Autowired EventPublisher eventPublisher;

  @GetMapping(path = "/startGame")
  public Integer pushMessageInQueue() {
    Integer generatedNumber = random.nextInt(MAX) + 1;
    log.info("GAME STARTS WITH GENERATED NUM : {}", generatedNumber);
    eventPublisher.publishEvent(new GameEvent(false, generatedNumber));
    return generatedNumber;
  }
}
