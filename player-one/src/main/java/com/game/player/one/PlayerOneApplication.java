package com.game.player.one;

import com.game.kafka.config.KafkaGeneralConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(KafkaGeneralConfig.class)
@ComponentScan(basePackages = "com.game")
@Slf4j
public class PlayerOneApplication {

  public static void main(String[] args) {

    SpringApplication.run(PlayerOneApplication.class, args);
  }
}
