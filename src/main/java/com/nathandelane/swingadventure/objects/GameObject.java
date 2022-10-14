package com.nathandelane.swingadventure.objects;

import java.awt.*;

public interface GameObject {

  void render(Graphics g);

  void update(GameObjectTranslation t);

  /**
   * Z-index: towards negative will be underneath towards positive.
   * @return
   */
  int getZIndex();

}
