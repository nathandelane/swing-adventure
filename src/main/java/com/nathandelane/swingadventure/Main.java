package com.nathandelane.swingadventure;

import com.nathandelane.swingadventure.init.GameObjectLoader;
import com.nathandelane.swingadventure.init.GameStateInitializer;
import com.nathandelane.swingadventure.init.SpriteLoader;

import static com.nathandelane.swingadventure.AdventureCanvas.WINDOW;

public class Main {

  private static void init() {
    SpriteLoader.loadSpriteSheets();
    GameStateInitializer.setupGameStates();
    GameObjectLoader.loadGameObjects();
  }

  public static void main(String[] args) {
    System.out.println("Welcome to the game!");

    init();

    WINDOW.run();
  }

}