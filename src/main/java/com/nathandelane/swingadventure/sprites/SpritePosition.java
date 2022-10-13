package com.nathandelane.swingadventure.sprites;

public class SpritePosition {

  public final int x;

  public final int y;

  public SpritePosition(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "SpriteRectangle{" +
      "x=" + x +
      ", y=" + y +
      '}';
  }

}
