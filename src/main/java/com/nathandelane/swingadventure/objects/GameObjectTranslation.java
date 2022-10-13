package com.nathandelane.swingadventure.objects;

public class GameObjectTranslation {

  public final float deltaX;

  public final float deltaY;

  public final float angle;

  public GameObjectTranslation(final float deltaX, final float deltaY) {
    this.deltaX = deltaX;
    this.deltaY = deltaY;
    this.angle = 0f;
  }

  public GameObjectTranslation(final float deltaX, final float deltaY, final float angle) {
    this.deltaX = deltaX;
    this.deltaY = deltaY;
    this.angle = angle;
  }

}
