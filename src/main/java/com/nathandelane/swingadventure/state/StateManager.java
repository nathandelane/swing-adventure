package com.nathandelane.swingadventure.state;

import com.nathandelane.swingadventure.AdventureCanvas;

import java.util.HashMap;
import java.util.Map;

public final class StateManager {

  public static final GameState NULL_GAME_STATE = new GameState() {
    @Override
    public void execute(final AdventureCanvas adventureCanvas) {
      // No-op
    }
  };

  public static final StateManager STATE_MANAGER = new StateManager();;

  private final Map<Object, GameState> gameStates;

  public StateManager() {
    gameStates = new HashMap<>();
  }

  public GameState getGameStateForKey(final Object key) {
    GameState gameState = NULL_GAME_STATE;

    if (key != null && gameStates.containsKey(key)) {
      gameState = gameStates.get(key);
    }

    return gameState;
  }

  public void addGameState(final Object key, final GameState gameState) {
    if (key == null) throw new RuntimeException("Key may not be null.");
    if (gameState == null) throw new RuntimeException("Game state may not be null.");

    if (key != null && !gameStates.containsKey(key)) {
      gameStates.put(key, gameState);
    }
    else {
      System.out.format("Warning: trying to add game state for existing or null key: %s%n", key);
    }
  }

  public void removeGameState(final Object key) {
    if (key != null && gameStates.containsKey(key)) {
      gameStates.remove(key);
    }
  }

}
