package ttt.actors;

import ttt.GameMap;
import ttt.GameMap.Move;

public class Opponent extends Actor {
  public Opponent(String symbol) {
    super(symbol);
  }

  @Override
  public Move makeMove(GameMap map) {
    return map.findBestMove();
	}
}
