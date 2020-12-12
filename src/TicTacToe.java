import java.io.File;
import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

/**
 * @author username
 *
 */
public class TicTacToe {
	public static final int SIZE = 3;
	
	/**
	 * @param arg
	 */
	public static void main(String[] args) {		
		welcome();

		final GameMap map = new GameMap(SIZE);
		final Actor player = new Player(map, "x");
		final Actor opponent = new Opponent(map, "0");

		System.out.printf("%s%n%n", map.draw());

		/* Main game loop */
		while (map.isMovesLeft() && map.getWinner().isEmpty()) {
			player.makeMove();
			opponent.makeMove();

			System.out.printf("%n%s%n%n", map.draw());
		}

		String winner = map.getWinner();
		
		if(winner.isEmpty()) {
			System.out.println("It's a tie");
		} else {
			System.out.printf("Congrats! \"%s\" is a winner%n", winner);
		}

		// File file = new File("results.txt");
		// boolean resutlsExists = file.exists();
	}

	public static void welcome() {
		System.out.print(
			"""
			Welcome to TicTacToe

			Select what to do:
				1. Play
				2. Show champions

			Enter option number: 
			"""
		);

		Integer read = Console.<Integer>readOneOf("Enter a valid option number!");

		Double::sum

		switch (read) {
			case 1:
				
				break;
			case 2:
				
				break;
			default:
				break;
		}

		Operation.valueOf("+").
	}
	
//	public static void fillMap(String[][] map) {
//		for (String[] row : map) {
//			Arrays.fill(row, PLACEHOLDER);
//		}
//	}
//	
	// public static void drawMap(String[][] map) {
	// 	String delimiter = String
	// 		.format("%n%s%n", ROW_DELIMITER.repeat(3 * WIDTH + WIDTH - 1));

	// 	String out = Stream.of(map)
	// 		.map((row) -> " " + String.join(COLUMN_DELIMITER, row) + " ")
	// 		.collect(Collectors.joining(delimiter));

	// 	System.out.printf("%s%n%n", out);
	// }
//	
//	public static boolean checkDiagonally(String[][] map, String symbol) {
//		String[] flatMap = flatten(map);
//		String diagonal = "";
//
//		for (int i = 0; i < WIDTH; i += WIDTH + 1) {
//			diagonal += flatMap[i];
//		}
//		
//		return !diagonal.contains(symbol);
//	}
//	
//	public static String[] flatten(String[][] arr) {
//	    return Stream.of(arr).flatMap(Stream::of).toArray(String[]::new);
//	}
//	
//	public static void evaluate() {
//		
//	}
}

enum Operation implements DoubleBinaryOperator {
	PLUS    ("+", (l, r) -> l + r),
	MINUS   ("-", (l, r) -> l - r),
	MULTIPLY("*", (l, r) -> l * r),
	DIVIDE  ("/", (l, r) -> l / r);

	private final String symbol;
	private final DoubleBinaryOperator binaryOperator;

	private Operation(final String symbol, final DoubleBinaryOperator binaryOperator) {
			this.symbol = symbol;
			this.binaryOperator = binaryOperator;
	}

	public String getSymbol() {
			return symbol;
	}

	@Override
	public double applyAsDouble(final double left, final double right) {
			return binaryOperator.applyAsDouble(left, right);
	}
}
