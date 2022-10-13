package com.nathandelane.swingadventure.sprites;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SpriteSheetTest {

  @Test
  public void testGetSpriteRectangleForIndex() {
    final Map<String, Integer> sm = new HashMap<>();
    sm.put("0", 16);

    final SpriteSheet spriteSheet = new SpriteSheet("spritesheets/fonts/basic.png", 20, 20, sm);
    final BufferedImage zeroImage = spriteSheet.getSpriteImage("0");

    assertNotNull(zeroImage);
  }

}
