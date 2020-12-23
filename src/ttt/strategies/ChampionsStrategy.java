package ttt.strategies;
import java.util.stream.Stream;

import ttt.util.Results;
import ttt.util.Results.Champion;

public class ChampionsStrategy implements IMenuStrategy {
  public final int SIZE = 3;

  @Override
  public void forward() {
    Champion[] champions = Results.getChampions();
    String[] lines = Stream.of(champions).map(Champion::toString).toArray(String[]::new);

    System.out.println(String.join("\n", lines));
  }
}
