import java.util.Scanner;

public class Player extends Actor {
  public GameMap map;
  public String symbol;

  private Scanner scanner;

  public Player(GameMap map, String symbol) {
    this.map = map;
    this.symbol = symbol;
    this.scanner = new Scanner(System.in);
  }

  @Override
  public void makeMove() {
    int row = 0;
    int col = 0;

    try {
      System.out.print("Enter a row: ");
      row = this.scanner.nextInt();
      System.out.print("Enter a col: ");
      col = this.scanner.nextInt();

      this.scanner.reset();
    } catch (Exception e) {
      System.out.println("Enter a valid row/col number!");

      this.makeMove();

      return;
    }

    if(
			row > this.map.size || row < 1 || 
			col > this.map.size || col < 1
		) {
      System.out.printf("Col/row number should be between %d and %d!%n%n", 1, this.map.size);
      
      this.makeMove();

      return;
		}

    GameMap.Move move = this.map.new Move(row - 1, col - 1);
    this.map.makeMove(move, this.symbol);
  }
}
