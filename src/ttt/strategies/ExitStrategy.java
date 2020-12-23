package ttt.strategies;

public class ExitStrategy implements IMenuStrategy {
  @Override
  public void forward() {
    System.exit(0);
  }
}
