package ttt.actors;

import ttt.GameMap;
import ttt.GameMap.Move;

public abstract class Actor {
  public String name;
  public String symbol;

  public Actor(String symbol) {
    this.symbol = symbol;
  }

  public Actor(String symbol, String name) {
    this.name = name;
    this.symbol = symbol;
  }

  public abstract Move makeMove(GameMap map);
}
