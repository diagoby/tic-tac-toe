package ttt.strategies;

import java.nio.file.Files;
import java.nio.file.Path;

public class ChampionsStrategy implements IMenuStrategy {
  public final int SIZE = 3;

  @Override
  public void forward() {
    try {
      String results = Files.readString(Path.of("results.txt"));
      System.out.println(results);
    } catch (Exception e) {
      System.out.println("File not found");
    }
  }
}
