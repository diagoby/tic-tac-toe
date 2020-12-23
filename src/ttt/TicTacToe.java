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
		System.out.print("Welcome to TicTacToe\n\n");

		showMenu();
	}

	public static void showMenu() {
		System.out.print(
			"""
			Select what to do:
				1. Play
				2. Show champions
				3. Exit
			"""
		);

		Map<String, IMenuStrategy> menuMap = new HashMap<String, IMenuStrategy>();
		menuMap.put("1", Menu.PLAY);
		menuMap.put("2", Menu.CHAMPIONS);
		menuMap.put("3", Menu.EXIT);

		String option = Console.readOneOf(menuMap.keySet(), "Enter option number: ");
		IMenuStrategy strategy = menuMap.get(option);

		strategy.forward();

		showMenu();
	}
}