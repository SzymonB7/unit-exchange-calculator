package pl.babiarz.unitexchangecalculator;

public enum Operator {
  SUM('+'),
  SUB('-'),
  MULTI('*'),
  DIV('/');


  public final char character;
  Operator(char character) {
    this.character = character;
  }


}
