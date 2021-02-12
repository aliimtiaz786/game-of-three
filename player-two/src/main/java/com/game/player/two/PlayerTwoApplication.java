package com.game.player.two;

import com.game.kafka.config.KafkaGeneralConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(KafkaGeneralConfig.class)
@ComponentScan(basePackages = "com.game")
public class PlayerTwoApplication {

  public static void main(String[] args) {
    SpringApplication.run(PlayerTwoApplication.class, args);
  }
}
