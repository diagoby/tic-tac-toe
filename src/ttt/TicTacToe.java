package ttt;

import java.util.HashMap;
import java.util.Map;

import ttt.strategies.IMenuStrategy;
import ttt.util.Console;

/**
 * @author username
 *
 */
public class TicTacToe {

	
	/**
	 * @param arg
	 */
	public static void main(String[] args) {		
		welcome();
	}

	public static void welcome() {
		System.out.print(
			"""
			Welcome to TicTacToe

			Select what to do:
				1. Play
				2. Show champions
			"""
		);

		Map<String, IMenuStrategy> menuMap = new HashMap<String, IMenuStrategy>();
		menuMap.put("1", Menu.PLAY);
		menuMap.put("2", Menu.CHAMPIONS);

		String option = Console.readOneOf(menuMap.keySet(), "Enter option number: ");
		IMenuStrategy strategy = menuMap.get(option);

		strategy.forward();
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

// enum Operation implements DoubleBinaryOperator {
// 	PLUS    ("+", (l, r) -> l + r),
// 	MINUS   ("-", (l, r) -> l - r),
// 	MULTIPLY("*", (l, r) -> l * r),
// 	DIVIDE  ("/", (l, r) -> l / r);

// 	private final String symbol;
// 	private final DoubleBinaryOperator binaryOperator;

// 	private Operation(final String symbol, final DoubleBinaryOperator binaryOperator) {
// 			this.symbol = symbol;
// 			this.binaryOperator = binaryOperator;
// 	}

// 	public String getSymbol() {
// 			return symbol;
// 	}

// 	@Override
// 	public double applyAsDouble(final double left, final double right) {
// 			return binaryOperator.applyAsDouble(left, right);
// 	}
// }
