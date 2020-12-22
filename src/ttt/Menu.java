package ttt;

import ttt.strategies.IMenuStrategy;
import ttt.strategies.PlayStrategy;
import ttt.strategies.ChampionsStrategy;

public enum Menu implements IMenuStrategy {
  PLAY(new PlayStrategy()),
  CHAMPIONS(new ChampionsStrategy());

  private final IMenuStrategy strategy;

  private Menu(IMenuStrategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public void forward() {
    this.strategy.forward();
  }
}
