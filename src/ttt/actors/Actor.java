package ttt.actors;

import ttt.GameMap;
import ttt.GameMap.Move;

public abstract class Actor {
  public String name;
  public String symbol;

  public Actor(String symbol) {
    this.symbol = symbol;
  }

  public Actor(String name, String symbol) {
    this.name = name;
    this.symbol = symbol;
  }

  public abstract Move makeMove(GameMap map);

  @Override
  public String toString() {
    return String.format("%s|%s", this.symbol, this.name);
  }
}
