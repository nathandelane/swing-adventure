package com.nathandelane.swingadventure.objects;

import java.awt.*;

public interface GameObject {

  void render(Graphics g);

  void update(final float deltaX, final float deltaY);

}
