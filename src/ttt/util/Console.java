package ttt.util;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Console {
  private final static Scanner scanner = new Scanner(System.in);

  public static String read(String prompt) {
    try {
      System.out.print(prompt);

      return scanner.next();
    } catch (Exception e) {
      System.out.print("Invalid value... ");

      return read(prompt);
    }
  }

  public static String readOneOf(Set<String> options, String prompt) {
    String[] optionsStrings = options.stream()
      .map(String::valueOf)
      .toArray(String[]::new);

    String patternString = String.format("^(%s)$", String.join("|", optionsStrings));

    try {
      System.out.print(prompt);

      return scanner.next(Pattern.compile(patternString));
    } catch (Exception e) {
      System.out.printf(
        "Invalid option. Value should be one of: %s%n", 
        String.join(", ", optionsStrings)
      );
      
      return readOneOf(options, prompt);
    }
  }
}
