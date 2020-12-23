package ttt;

import ttt.strategies.IMenuStrategy;
import ttt.strategies.PlayStrategy;
import ttt.strategies.ChampionsStrategy;
import ttt.strategies.ExitStrategy;

public enum Menu implements IMenuStrategy {
  PLAY(new PlayStrategy()),
  CHAMPIONS(new ChampionsStrategy()),
  EXIT(new ExitStrategy());

  private final IMenuStrategy strategy;

  private Menu(IMenuStrategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public void forward() {
    this.strategy.forward();
  }
}
