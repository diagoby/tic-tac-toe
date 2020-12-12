import java.util.function.DoubleBinaryOperator;

public enum Menu implements DoubleBinaryOperator {
  PLAY(1, (l, r) -> l + r);

  @Override
  public double applyAsDouble(double left, double right) {
    // TODO Auto-generated method stub
    return 0;
  }

}
