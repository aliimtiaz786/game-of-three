package com.game.player.two.kafka.config;

import com.game.kafka.model.Player;
import com.game.kafka.publisher.EventPublisher;
import com.game.kafka.service.GameServiceImpl;
import com.game.kafka.service.GameService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfigs {

  @Value("${player.name}")
  private String playerName;

  @Bean
  public GameService gameService(EventPublisher eventPublisher) {
    return new GameServiceImpl(eventPublisher, new Player(playerName));
  }
}
