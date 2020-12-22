package ttt;

import ttt.actors.Actor;
import ttt.actors.Opponent;
import ttt.actors.Player;

public class Game {
  public final int SIZE = 3;
  public final Player player;

  public Game(Player player) {
    this.player = player;
  }

  public void start() {
		final Actor opponent = new Opponent(this.player.symbol == "x" ? "o" : "x");
		final GameMap map = new GameMap(this.SIZE, this.player, opponent);

    System.out.printf("%s%n%n", map.draw());

		/* Main game loop */
		while (map.isMovesLeft() && map.getWinner() != null) {
			map.makeMove(player);
			map.makeMove(opponent);

			System.out.printf("%n%s%n%n", map.draw());
		}

		Actor winner = map.getWinner();
		
		if(winner == null) {
			System.out.println("It's a tie");
		} else {
			System.out.printf("Congrats! \"%s\" is a winner%n", winner);
		}
  }
}
