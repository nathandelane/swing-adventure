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

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");

    setupGameStates();
    loadSpriteSheets();

    final AdventureCanvas window = AdventureCanvas.get();
    final GameObject burner = new Burner(20, 20, 64, 64);
    final AdventureTextBox adventureTextBox = new AdventureTextBox(5, 80, 1014, 756);
    adventureTextBox.addText("Hello, World!");

    window.addGameObject(burner);
    window.addGameObject(adventureTextBox);
    window.run();
  }

  private static void setupGameStates() {
    final StateManager sm = StateManager.get();

    sm.addGameState(KeyEvent.VK_ESCAPE, AdventureStates.STOP_GAME);
    sm.addGameState(KeyEvent.VK_RIGHT, AdventureStates.MOVE_BURNER_RIGHT);
    sm.addGameState(KeyEvent.VK_LEFT, AdventureStates.MOVE_BURNER_LEFT);
    sm.addGameState(KeyEvent.VK_UP, AdventureStates.MOVE_BURNER_UP);
    sm.addGameState(KeyEvent.VK_DOWN, AdventureStates.MOVE_BURNER_DOWN);
  }

  private static void loadSpriteSheets() {
    final String spriteStream = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\tabcdefghijklmnopqrstuvwxyz{|}~";
    final Map<String, Integer> sm = new HashMap<>();
    for (int charIndex = 0; charIndex < spriteStream.length(); charIndex++) {
      final char c = spriteStream.charAt(charIndex);
      final String charAsString = String.format("%s", c);

      sm.put(charAsString, charIndex);
    }

    final SpriteSheet spriteSheet = new SpriteSheet("spritesheets/fonts/basic.png", 20, 20, sm);

    SpriteSheetManager.get().addSpriteSheet("basic", spriteSheet);
  }

}