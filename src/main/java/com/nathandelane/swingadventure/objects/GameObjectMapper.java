package com.nathandelane.swingadventure.objects;

import java.util.concurrent.atomic.AtomicInteger;

public final class GameObjectMapper {

  private static GameObjectMapper GAME_OBJECT_MAPPER;

  private final AtomicInteger idGenerator;

  private GameObjectMapper() {
    idGenerator = new AtomicInteger(0);
  }

  private static GameObjectMapper get() {
    if (GAME_OBJECT_MAPPER == null) {
      GAME_OBJECT_MAPPER = new GameObjectMapper();
    }

    return GAME_OBJECT_MAPPER;
  }

  public static int getNextId() {


    return get().idGenerator.getAndIncrement();
  }

  public static void useUpTo(final int value) {
    while (get().idGenerator.getAndIncrement() != value) {
      // No-op
    }
  }

}
