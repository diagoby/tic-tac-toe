package ttt.strategies;
import java.util.stream.Stream;

import ttt.util.Results;
import ttt.util.Results.Champion;

public class ChampionsStrategy implements IMenuStrategy {
  @Override
  public void forward() {
    Champion[] champions = Results.getChampions();
    String[] lines = Stream.of(champions).map(Champion::toString).toArray(String[]::new);

    System.out.println(
      lines.length == 0 
        ? "No champions yet...\n"
        : String.join("\n", lines).concat("\n")
    );
  }
}
