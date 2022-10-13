package com.nathandelane.swingadventure.objects;

import java.awt.*;

public interface GameObject {

  void render(Graphics g);

  void update(GameObjectTranslation t);

}
