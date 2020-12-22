package ttt.actors;

import ttt.GameMap;
import ttt.GameMap.Move;

public abstract class Actor {
  public String name;
  public String symbol;
  public abstract Move makeMove(GameMap map);
}
