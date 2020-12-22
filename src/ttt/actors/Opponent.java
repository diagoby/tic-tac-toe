package ttt.actors;

import ttt.GameMap;
import ttt.GameMap.Move;

public class Opponent extends Actor {
  String symbol;

  public Opponent(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public Move makeMove(GameMap map) {
    return map.findBestMove();
	}
}
