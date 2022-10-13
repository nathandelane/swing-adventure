package com.nathandelane.swingadventure.state;

import com.nathandelane.swingadventure.AdventureCanvas;

public interface GameState {

  void execute(AdventureCanvas adventureCanvas);

}
