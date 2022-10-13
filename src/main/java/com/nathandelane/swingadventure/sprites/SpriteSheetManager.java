package com.nathandelane.swingadventure.sprites;

import java.util.HashMap;
import java.util.Map;

public final class SpriteSheetManager {

  private static SpriteSheetManager INSTANCE;

  private final Map<String, SpriteSheet> spriteSheetMap;

  private SpriteSheetManager() {
    spriteSheetMap = new HashMap<>();
  }

  public SpriteSheet getSpriteSheet(final String spriteSheetName) {
    if (spriteSheetName == null || spriteSheetName.trim().equals("")) throw new RuntimeException("Sprite sheet name may not be null or empty.");

    SpriteSheet spriteSheet = null;

    if (spriteSheetMap.containsKey(spriteSheetName)) {
      spriteSheet = spriteSheetMap.get(spriteSheetName);
    }

    return spriteSheet;
  }

  public void addSpriteSheet(final String spriteSheetName, final SpriteSheet spriteSheet) {
    if (spriteSheetName == null || spriteSheetName.trim().equals("")) throw new RuntimeException("Sprite sheet name may not be null or empty.");
    if (spriteSheet == null) throw new RuntimeException("Sprite sheet may not be null.");

    if  (!spriteSheetMap.containsKey(spriteSheetName)) {
      spriteSheetMap.put(spriteSheetName, spriteSheet);
    }
    else {
      System.out.format("Warning: trying to add sprite sheet for existing or null sprite sheet name: %s%n", spriteSheetName);
    }
  }

  public static SpriteSheetManager get() {
    if (INSTANCE == null) {
      INSTANCE = new SpriteSheetManager();
    }

    return INSTANCE;
  }

}
