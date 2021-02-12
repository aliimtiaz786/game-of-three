package com.game.player.one;

import com.game.kafka.config.KafkaGeneralConfig;
import com.game.kafka.model.GameEvent;
import com.game.kafka.publisher.EventPublisher;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(KafkaGeneralConfig.class)
@ComponentScan(basePackages = "com.game")
@Slf4j
public class PlayerOneApplication {

  private static final Random random = new Random();
  private static final int MAX = 10000;

  public static void main(String[] args) {

    ConfigurableApplicationContext context =
        SpringApplication.run(PlayerOneApplication.class, args);

    var eventPublisher = context.getBean(EventPublisher.class);
    Integer generatedNumber = random.nextInt(MAX) + 1;
    log.info("GAME STARTS WITH GENERATED NUM : {}", generatedNumber);
    eventPublisher.publishEvent(new GameEvent(false, generatedNumber));
  }
}
