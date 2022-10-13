package com.nathandelane.swingadventure;

import com.nathandelane.swingadventure.sprites.SpriteSheet;
import com.nathandelane.swingadventure.sprites.SpriteSheetManager;

import java.util.HashMap;
import java.util.Map;

import static com.nathandelane.swingadventure.sprites.SpriteSheetManager.SPRITE_SHEET_MANAGER;

public final class SpriteLoader {

  private SpriteLoader() { }

  public static void loadSpriteSheets() {
    final String spriteStream = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\tabcdefghijklmnopqrstuvwxyz{|}~";
    final Map<String, Integer> sm = new HashMap<>();
    for (int charIndex = 0; charIndex < spriteStream.length(); charIndex++) {
      final char c = spriteStream.charAt(charIndex);
      final String charAsString = String.format("%s", c);

      sm.put(charAsString, charIndex);
    }

    final SpriteSheet spriteSheet = new SpriteSheet("spritesheets/fonts/basic.png", 20, 20, sm);

    SPRITE_SHEET_MANAGER.addSpriteSheet("basic", spriteSheet);
  }

}
