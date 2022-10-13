package com.nathandelane.swingadventure.sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class SpriteSheet {

  private final int width;

  private final int height;

  private final int spriteWidth;

  private final int spriteHeight;

  private final BufferedImage image;

  private final Map<String, Integer> spriteMap;

  public SpriteSheet(final String resourcePath, final int spriteWidth, final int spriteHeight, final Map<String, Integer> spriteMap) {
    if (resourcePath == null || resourcePath.trim().equals("")) throw new RuntimeException("Resource path may not be null or an empty String.");
    if (spriteMap == null || spriteMap.isEmpty()) throw new RuntimeException("Sprite map may not be null or empty.");

    BufferedImage tempImage = null;

    try (final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
      tempImage = ImageIO.read(inputStream);
    } catch (final IOException e) {
      e.printStackTrace();

      throw new RuntimeException(e);
    }
    finally {
      if (tempImage != null) {
        image = tempImage;
      }
      else {
        image = null;
      }
    }

    this.width = image.getWidth();
    this.height = image.getHeight();
    this.spriteWidth = spriteWidth;
    this.spriteHeight = spriteHeight;
    this.spriteMap = spriteMap;
  }

  public BufferedImage getSpriteImage(final String spriteKey) {
    if (spriteKey == null || spriteKey.equals("")) throw new RuntimeException("Sprite key may not be null or an empty String.");

    BufferedImage spriteImage = null;

    if (spriteMap.containsKey(spriteKey)) {
      final int index = spriteMap.get(spriteKey);
      final SpritePosition spritePosition = getSpriteRectangleForIndex(index);

      spriteImage = image.getSubimage(spritePosition.x, spritePosition.y, spriteWidth, spriteHeight);
    }

    return spriteImage;
  }

  SpritePosition getSpriteRectangleForIndex(final int index) {
    final int yPos = (index / (width / spriteWidth)) * spriteWidth;
    final int xPos = (index % (width / spriteWidth)) * spriteHeight;

    return new SpritePosition(xPos, yPos);
  }

}
