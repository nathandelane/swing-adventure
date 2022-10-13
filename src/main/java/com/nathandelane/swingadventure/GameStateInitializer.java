package com.nathandelane.swingadventure;

import com.nathandelane.swingadventure.state.AdventureStates;

import java.awt.event.KeyEvent;

import static com.nathandelane.swingadventure.state.StateManager.STATE_MANAGER;

public final class GameStateInitializer {

  private GameStateInitializer() { }

  public static void setupGameStates() {
    STATE_MANAGER.addGameState(KeyEvent.VK_ESCAPE, AdventureStates.STOP_GAME);
    STATE_MANAGER.addGameState(KeyEvent.VK_RIGHT, AdventureStates.MOVE_BURNER_RIGHT);
    STATE_MANAGER.addGameState(KeyEvent.VK_LEFT, AdventureStates.MOVE_BURNER_LEFT);
    STATE_MANAGER.addGameState(KeyEvent.VK_UP, AdventureStates.MOVE_BURNER_UP);
    STATE_MANAGER.addGameState(KeyEvent.VK_DOWN, AdventureStates.MOVE_BURNER_DOWN);
  }

}
