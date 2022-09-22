package pl.babiarz.unitexchangecalculator.model;

public enum ArithmeticOperator {
  SUM('+'),
  SUB('-'),
  MULTI('*'),
  DIV('/');


  public final char character;
  ArithmeticOperator(char character) {
    this.character = character;
  }


}
