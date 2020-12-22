package ttt.strategies;

import java.util.Set;

import ttt.Game;
import ttt.actors.Actor;
import ttt.actors.Player;
import ttt.util.Console;

public class PlayStrategy implements IMenuStrategy {

  @Override
  public void forward() {
    String name = Console.read("Enter player's name: ");
    String symbol = Console.readOneOf(Set.of("x", "o"), "Choose symbol to play (x/o): ");

    Actor player = new Player(symbol, name);
    Game game = new Game(player);
  
    game.start();
  }
}
