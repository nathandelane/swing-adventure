package com.nathandelane.swingadventure;

import static com.nathandelane.swingadventure.AdventureCanvas.WINDOW;

public class Main {

  public static void main(String[] args) {
    System.out.println("Welcome to the game!");

    SpriteLoader.loadSpriteSheets();
    GameStateInitializer.setupGameStates();
    GameObjectLoader.loadGameObjects();

    WINDOW.run();
  }

}