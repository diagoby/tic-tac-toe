public class Opponent extends Actor {
  GameMap map;
  String symbol;

  public Opponent(GameMap map, String symbol) {
    this.map = map;
    this.symbol = symbol;
  }

  @Override
  public void makeMove() {
    GameMap.Move move = this.map.findBestMove();
    this.map.makeMove(move, this.symbol);
	}
}
