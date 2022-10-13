package com.nathandelane.swingadventure;

import com.nathandelane.swingadventure.objects.AdventureTextBox;
import com.nathandelane.swingadventure.objects.Burner;
import com.nathandelane.swingadventure.objects.GameObject;

import static com.nathandelane.swingadventure.AdventureCanvas.WINDOW;

public final class GameObjectLoader {

  private GameObjectLoader() { }

  public static final void loadGameObjects() {
    final GameObject burner = new Burner(20, 20, 64, 64);
    final AdventureTextBox adventureTextBox = new AdventureTextBox(5, 80, 1014, 756);
    adventureTextBox.addText("Hello, World!");

    WINDOW.addGameObject(burner);
    WINDOW.addGameObject(adventureTextBox);
  }

}
