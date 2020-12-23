package ttt.actors;

import java.util.Scanner;

import ttt.GameMap;
import ttt.GameMap.Move;

public class Player extends Actor {
  private static final Scanner scanner = new Scanner(System.in);

  public String symbol;
  public String name;

  public Player(String name, String symbol) {
    super(name, symbol);
  }

  @Override
  public Move makeMove(GameMap map) {
    int row = 0;
    int col = 0;

    try {
      System.out.print("Enter a row: ");
      row = scanner.nextInt();
      System.out.print("Enter a col: ");
      col = scanner.nextInt();

      scanner.reset();
    } catch (Exception e) {
      System.out.println("Enter a valid row/col number!");

      return this.makeMove(map);
    }

    if(
			row > map.size || row < 1 || 
			col > map.size || col < 1
		) {
      System.out.printf("Col/row number should be between %d and %d!%n%n", 1, map.size);
      
      return this.makeMove(map);
		}

    Move move = new Move(row - 1, col - 1);

    if(!map.isCellEmpty(move)) {
      System.out.println("This cell isn't empty. Choose another one...");

      return this.makeMove(map);
    }

    return move;
  }
}
