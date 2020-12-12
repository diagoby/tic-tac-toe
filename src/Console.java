import java.util.Scanner;

public class Console {
  private final static Scanner scanner = new Scanner(System.in);

  public static <T> T read(String errorMessage) {
    T input = null;

    try {
      input = (T) scanner.next();

      return input;
    } catch (Exception e) {
      System.out.println(errorMessage);
      
      return read(errorMessage);
    }
  }
}
