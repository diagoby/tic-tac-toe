package ttt.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Results
 */
public class Results {
  private static final Record[] NO_RECORDS = {};
  private static final Path RESULTS_FILE_PATH = Paths.get("results.txt");

  public static void save(Record record) {
    StandardOpenOption[] openOptions = new StandardOpenOption[] { 
      StandardOpenOption.CREATE, 
      StandardOpenOption.WRITE,
      StandardOpenOption.APPEND 
    };

    try {
      String line = String.format("%s%n", record.toString());
      Files.writeString(RESULTS_FILE_PATH, line, openOptions);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Record[] readAll() {
    try {
      return Files.readAllLines(RESULTS_FILE_PATH).stream()
        .map(Record::fromString).toArray(Record[]::new);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return NO_RECORDS;
  }

  public static Champion[] getChampions() {
    Record[] records = readAll();

    Map<String, Long> championsMap = Stream.of(records)
      .collect(Collectors.groupingBy(Record::getWinner, Collectors.counting()));

    return championsMap.entrySet().stream()
      .map(c -> new Champion(c.getKey(), c.getValue())).toArray(Champion[]::new);
  }

  public static class Champion {
    public String name;
    public Long wins;

    public Champion(String name, Long wins) {
      this.name = name;
      this.wins = wins;
    }

    @Override
    public String toString() {
      return String.format("%s - %d wins", this.name, this.wins);
    }
  }

  public static class Record {
    private String winner;
    private String opponent;

    public Record(String winner, String opponent) {
      this.winner = winner;
      this.opponent = opponent;
    }

    @Override
    public String toString() {
      return String.format("winner: %s; opponent: %s", this.winner, this.opponent);
    }

    public static Record fromString(String line) {
      Pattern pattern = Pattern.compile("winner: (?<winner>\\w+); opponent: (?<opponent>\\w+)");
      Matcher matcher = pattern.matcher(line);

      if(matcher.find()) {
        return new Record(matcher.group("winner"), matcher.group("opponent"));
      }

      return null;
    }

    public String getWinner() {
      return this.winner;
    }

    public String getOpponent() {
      return this.opponent;
    }
  }
}