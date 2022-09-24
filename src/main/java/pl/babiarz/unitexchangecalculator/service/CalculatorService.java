package pl.babiarz.unitexchangecalculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.babiarz.unitexchangecalculator.model.Calculation;

@Service
@AllArgsConstructor
public class CalculatorService {
  private final UnitConverter unitConverter;

  public BigDecimal calculate(Calculation calculation) {
    BigDecimal convertedValue1 = unitConverter.getUnitValue(calculation.getValue1(), calculation.getUnit());
    BigDecimal convertedValue2 = unitConverter.getUnitValue(calculation.getValue2(), calculation.getUnit());
    return switch (calculation.getArithmeticOperator()) {
      case SUM -> convertedValue1.add(convertedValue2).setScale(2, RoundingMode.DOWN);
      case SUB -> convertedValue1.subtract(convertedValue2).setScale(2, RoundingMode.DOWN);
      case MULTI -> convertedValue1.multiply(convertedValue2).setScale(2, RoundingMode.DOWN);
      case DIV -> convertedValue1.divide(convertedValue2, 2, RoundingMode.DOWN);
    };
  }
}
