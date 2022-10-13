package com.nathandelane.swingadventure.objects;

import com.nathandelane.swingadventure.sprites.SpriteSheet;
import com.nathandelane.swingadventure.sprites.SpriteSheetManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AdventureTextBox implements GameObject {

  private int x;

  private int y;

  private final int id;

  private final int width;

  private final int height;

  private final StringBuilder text;

  public AdventureTextBox(final int startX, final int startY, final int width, final int height) {
    this.text = new StringBuilder();
    this.id = 2;

    GameObjectMapper.useUpTo(2);

    this.x = startX;
    this.y = startY;
    this.width = width;
    this.height = height;
  }

  public void addText(final String str) {
    text.append(str);
  }

  @Override
  public void render(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    final String stringToRender = text.toString();

    int cursorX = x;
    int cursorY = y;

    final SpriteSheet basicText = SpriteSheetManager.get().getSpriteSheet("basic");

    for (int i = 0; i < stringToRender.length(); i++) {
      final String key = "" + stringToRender.charAt(i);

      if (key != null && !key.equals("")) {
        final BufferedImage spriteForLetter = basicText.getSpriteImage(key);
        final int spriteWidth = spriteForLetter.getWidth();
        final int spriteHeight = spriteForLetter.getHeight();

        g2.drawImage(spriteForLetter, cursorX, cursorY, spriteWidth, spriteHeight, null);

        cursorX += spriteWidth;
      }
    }
  }

  @Override
  public void update(float deltaX, float deltaY) {
    // No-op - this doesn't move yet.
  }

}
