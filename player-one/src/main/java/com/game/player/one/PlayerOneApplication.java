package com.game.player.one;

import com.game.kafka.config.KafkaGeneralConfig;
import com.game.kafka.model.GameEvent;
import com.game.kafka.publisher.EventPublisher;
import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(KafkaGeneralConfig.class)
@ComponentScan(basePackages = "com.game")
public class PlayerOneApplication {

  private static final Random random = new Random();
  private static final int MAX = 10000;

  public static void main(String[] args) {

    ConfigurableApplicationContext context =
        SpringApplication.run(PlayerOneApplication.class, args);

    var producer = context.getBean(EventPublisher.class);
    Integer num = random.nextInt(MAX) + 1;
    producer.publishEvent(new GameEvent(false, num));
  }
}
