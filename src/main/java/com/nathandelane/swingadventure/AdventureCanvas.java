package com.nathandelane.swingadventure;

import com.nathandelane.swingadventure.events.EventHandler;
import com.nathandelane.swingadventure.objects.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class AdventureCanvas extends JPanel implements Runnable {

  public static final Dimension RESOLUTION = new Dimension(1024, 768);

  public static final AdventureCanvas WINDOW = new AdventureCanvas();

  private static final double NANO_SECONDS_PER_SECOND = 1000_000_000D;

  private static final int FRAMES_PER_SECOND = 60;

  private JFrame frame;

  private boolean isRunning;

  private int tickCount;

  private Thread gameThread;

  private final Set<GameObject> gameObjects;

  private final double nanoSecondsPerTick;

  private AdventureCanvas() {
    nanoSecondsPerTick = NANO_SECONDS_PER_SECOND / FRAMES_PER_SECOND;
    isRunning = false;
    tickCount = 0;
    gameObjects = new HashSet<>();

    init();
    start();
  }

  public synchronized void start() {
    isRunning = true;

    gameThread = new Thread(this);
    gameThread.start();
  }

  public synchronized void stop() {
    isRunning = false;

    System.exit(0);
  }

  @Override
  public void run() {
    long lastTime = System.nanoTime();

    int ticks = 0;
    int frames = 0;

    long lastTimer = System.currentTimeMillis();
    double delta = 0;

    while (isRunning) {
      long now = System.nanoTime();
      delta += (now - lastTime) / nanoSecondsPerTick;
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

        update();
        repaint();
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

  public void update() {

  }

  @Override
  public void paintComponent(final Graphics g) {
    super.paintComponent(g);

    final Graphics2D g2 = (Graphics2D) g;

    for (final GameObject nextGameObject : gameObjects) {
      nextGameObject.render(g2);
    }

    g2.dispose();
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
    frame.pack();

    final EventHandler eventHandler = new EventHandler(this);

    this.setFocusable(true);
    this.addKeyListener(eventHandler);
    this.setBackground(Color.BLACK);
    this.setDoubleBuffered(true);

    frame.setVisible(true);

    isRunning = true;
  }

}
