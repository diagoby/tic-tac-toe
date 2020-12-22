package ttt.util;

import java.util.Scanner;
import java.util.Set;

public class Console {
  private final static Scanner scanner = new Scanner(System.in);

  public static String read(String prompt) {
    System.out.print(prompt);
  
    try (Scanner tokenizer = new Scanner(scanner.nextLine())) {
      return tokenizer.next();
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

    System.out.print(prompt);

    try (Scanner tokenizer = new Scanner(scanner.nextLine())) {
      return tokenizer.next(patternString);
    } catch (Exception e) {
      System.out.printf(
        "Invalid option. Value should be one of: %s%n", 
        String.join(", ", optionsStrings)
      );
      
      return readOneOf(options, prompt);
    }
  }
}
