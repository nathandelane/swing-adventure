package com.nathandelane.swingadventure;

import com.nathandelane.swingadventure.objects.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class AdventureCanvas extends Canvas implements Runnable {

  public static final Dimension RESOLUTION = new Dimension(1024, 769);

  private static AdventureCanvas WINDOW;

  private JFrame frame;

  private boolean isRunning;

  private int tickCount;

  private final Set<GameObject> gameObjects;

  private AdventureCanvas() {
    isRunning = false;
    tickCount = 0;
    gameObjects = new HashSet<>();

    init();
    start();
  }

  public synchronized void start() {
    new Thread(this).start();

    isRunning = true;
  }

  public synchronized void stop() {
    isRunning = false;

    System.exit(0);
  }

  @Override
  public void run() {
    createBufferStrategy(2);

    long lastTime = System.nanoTime();
    double nsPerTick = 1000000000D / 60;

    int ticks = 0;
    int frames = 0;

    long lastTimer = System.currentTimeMillis();
    double delta = 0;

    while (isRunning) {
      long now = System.nanoTime();
      delta += (now - lastTime) / nsPerTick;
      lastTime = now;
      boolean shouldRender = true;

      while (delta >= 1) {
        ticks++;
        tick();
        delta -= 1;
        shouldRender = true;
      }

      try {
        Thread.sleep(2);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }

      if (shouldRender) {
        frames++;
        render();

        shouldRender = false;
      }

      if (System.currentTimeMillis() - lastTimer >= 1000) {
        lastTimer += 1000;
        System.out.println(ticks + " ticks, " + frames + " frames");
        frames = 0;
        ticks = 0;
      }
    }
  }

  public void addGameObject(final GameObject gameObject) {
    gameObjects.add(gameObject);
  }

  public void removeGameObject(final GameObject gameObject) {
    gameObjects.remove(gameObject);
  }

  public Set<GameObject> getGameObjects() {
    return Collections.unmodifiableSet(gameObjects);
  }

  public void render () {
    BufferStrategy bs = getBufferStrategy();

    if (bs == null) {
      createBufferStrategy(2);

      bs = getBufferStrategy();
    }

    do {
      do {
        final Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, RESOLUTION.width, RESOLUTION.height);

        for (final GameObject nextGameObject : gameObjects) {
          nextGameObject.render(g2);
        }

        g2.dispose();
      } while (bs.contentsRestored());

      bs.show();
    } while (bs.contentsLost());
  }

  private void tick(){
    tickCount++;

    //Do game updates here
  }

  private void init() {
    frame = new JFrame();
    frame.setTitle("Swing Adventure");
    frame.setSize(RESOLUTION);
    frame.setMinimumSize(RESOLUTION);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLayout(new BorderLayout());
    frame.add(this);

    final EventHandler eventHandler = new EventHandler(this);

    frame.addKeyListener(eventHandler);

    this.setIgnoreRepaint(true);

    frame.setVisible(true);
    frame.setIgnoreRepaint(true);

    isRunning = true;
  }

  public static AdventureCanvas get() {
    if (AdventureCanvas. WINDOW == null) {
      AdventureCanvas.WINDOW = new AdventureCanvas();
    }

    return AdventureCanvas.WINDOW;
  }

}
