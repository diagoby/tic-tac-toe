package ttt.util;

import ttt.actors.Actor;

/**
 * Results
 */
public class Results {
  public static void save(Record record) {
    
  }

  public static class Record {
    // public final Pattern PATTERN = Pattern.compile("win:\\w+|opp:\\w+");

    private Actor winner;
    private Actor opponent;

    public Record(Actor winner, Actor opponent) {
      this.winner = winner;
      this.opponent = opponent;
    }

    @Override
    public String toString() {
      return String.format("win:%s|opp:%s", this.winner.name, this.opponent.name);
    }
  }
}