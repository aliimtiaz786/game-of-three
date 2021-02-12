package com.game.kafka.service;

import com.game.kafka.model.GameEvent;

public interface GameService {

  public void listenMessage(GameEvent gameEvent);
}
