package com.nathandelane.swingadventure;

import com.nathandelane.swingadventure.state.GameState;
import com.nathandelane.swingadventure.state.StateManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.nathandelane.swingadventure.state.StateManager.STATE_MANAGER;

public class EventHandler extends KeyAdapter {

  private final AdventureCanvas adventureCanvas;

  public EventHandler(final AdventureCanvas adventureCanvas) {
    this.adventureCanvas = adventureCanvas;
  }

  @Override
  public void keyPressed(final KeyEvent e) {
    final int keyCode = e.getKeyCode();
    final GameState gameState = STATE_MANAGER.getGameStateForKey(keyCode);

    if (gameState != null) {
      gameState.execute(adventureCanvas);
    }
    else {
      System.out.println("No game state found for key code.");
    }

    e.consume();
  }

}
