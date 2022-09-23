package pl.babiarz.unitexchangecalculator.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Calculation {
  Value value1;
  Value value2;
  private ArithmeticOperator arithmeticOperator;
  private Unit unit;
}
