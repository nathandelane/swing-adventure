package com.nathandelane.swingadventure.state;

import com.nathandelane.swingadventure.AdventureCanvas;
import com.nathandelane.swingadventure.objects.Burner;
import com.nathandelane.swingadventure.objects.GameObject;
import com.nathandelane.swingadventure.objects.GameObjectTranslation;

public final class AdventureStates {

  private AdventureStates() { }

  public static final GameState STOP_GAME = new GameState() {
    @Override
    public void execute(final AdventureCanvas adventureCanvas) {
      adventureCanvas.stop();
    }
  };

  public static final GameState MOVE_BURNER_RIGHT = new GameState() {
    @Override
    public void execute(final AdventureCanvas adventureCanvas) {
      final Burner burner = null;

      for (final GameObject gameObject : adventureCanvas.getGameObjects()) {
        if (gameObject instanceof Burner) {
          gameObject.update(new GameObjectTranslation(5.0f, 0));
        }
      }
    }
  };

  public static final GameState MOVE_BURNER_LEFT = new GameState() {
    @Override
    public void execute(final AdventureCanvas adventureCanvas) {
      final Burner burner = null;

      for (final GameObject gameObject : adventureCanvas.getGameObjects()) {
        if (gameObject instanceof Burner) {
          gameObject.update(new GameObjectTranslation(-5.0f, 0));
        }
      }
    }
  };

  public static final GameState MOVE_BURNER_UP = new GameState() {
    @Override
    public void execute(final AdventureCanvas adventureCanvas) {
      final Burner burner = null;

      for (final GameObject gameObject : adventureCanvas.getGameObjects()) {
        if (gameObject instanceof Burner) {
          gameObject.update(new GameObjectTranslation(0f, -5.0f));
        }
      }
    }
  };

  public static final GameState MOVE_BURNER_DOWN = new GameState() {
    @Override
    public void execute(final AdventureCanvas adventureCanvas) {
      final Burner burner = null;

      for (final GameObject gameObject : adventureCanvas.getGameObjects()) {
        if (gameObject instanceof Burner) {
          gameObject.update(new GameObjectTranslation(0f, 5.0f));
        }
      }
    }
  };

  public static final GameState KEY_TYPED = new GameState() {
    @Override
    public void execute(final AdventureCanvas adventureCanvas) {

    }
  };

}
