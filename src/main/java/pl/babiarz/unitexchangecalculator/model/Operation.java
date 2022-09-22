package pl.babiarz.unitexchangecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Operation {
  private Value value1;
  private Value value2;
  private ArithmeticOperator arithmeticOperator;
  private Unit unit;
}
