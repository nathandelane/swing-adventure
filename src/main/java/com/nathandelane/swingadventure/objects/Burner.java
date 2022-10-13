package com.nathandelane.swingadventure.objects;

import com.nathandelane.swingadventure.AdventureCanvas;

import java.awt.*;
import java.util.Objects;

public class Burner implements GameObject {

  private int x;

  private int y;

  private final int id;

  private final int width;

  private final int height;

  public Burner(final int startX, final int startY, final int width, final int height) {
    this.id = 1;

    GameObjectMapper.useUpTo(1);

    this.x = startX;
    this.y = startY;
    this.width = width;
    this.height = height;
  }

  @Override
  public void update(final GameObjectTranslation t) {
    final float newX = ((float) this.x + t.deltaX);
    final float newY = ((float) this.y + t.deltaY);

    if (
      (newX + width) < AdventureCanvas.RESOLUTION.width
      && (newX) >= 0
    ) {
      this.x = (int) newX;
    }

    if (
      (newY + height) < AdventureCanvas.RESOLUTION.height
        && (newY) >= 0
    ) {
      this.y = (int) newY;
    }
  }

  @Override
  public void render(final Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    g2.setColor(Color.RED);
    g2.fillRect(x, y, width, height);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Burner burner = (Burner) o;
    return id == burner.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Burner{" +
      "x=" + x +
      ", y=" + y +
      ", id=" + id +
      ", width=" + width +
      ", height=" + height +
      '}';
  }

}
