package com.nathandelane.swingadventure;

import com.nathandelane.swingadventure.objects.AdventureTextBox;
import com.nathandelane.swingadventure.objects.Burner;
import com.nathandelane.swingadventure.objects.GameObject;
import com.nathandelane.swingadventure.sprites.SpriteSheet;
import com.nathandelane.swingadventure.sprites.SpriteSheetManager;
import com.nathandelane.swingadventure.state.AdventureStates;
import com.nathandelane.swingadventure.state.StateManager;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import static com.nathandelane.swingadventure.AdventureCanvas.WINDOW;
import static com.nathandelane.swingadventure.state.StateManager.STATE_MANAGER;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");

    GameStateInitializer.setupGameStates();
    SpriteLoader.loadSpriteSheets();

    final GameObject burner = new Burner(20, 20, 64, 64);
    final AdventureTextBox adventureTextBox = new AdventureTextBox(5, 80, 1014, 756);
    adventureTextBox.addText("Hello, World!");

    WINDOW.addGameObject(burner);
    WINDOW.addGameObject(adventureTextBox);
    WINDOW.run();
  }

}