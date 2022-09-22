package pl.babiarz.unitexchangecalculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import pl.babiarz.unitexchangecalculator.model.Operation;
import pl.babiarz.unitexchangecalculator.model.Value;

@Service
public class CalculatorService {
  UnitConverter unitConverter;
  public BigDecimal addBasicValues(Value value1, Value value2){
    return value1.getBasicValue().add(value2.getBasicValue());
  }
  public BigDecimal subtractBasicValues(Value value1, Value value2){
    return value1.getBasicValue().subtract(value2.getBasicValue());
  }
  public BigDecimal multiplyBasicValues(Value value1, Value value2){
    return value1.getBasicValue().multiply(value2.getBasicValue());
  }
  public BigDecimal divideBasicValues(Value value1, Value value2){
    return value1.getBasicValue().divide(value2.getBasicValue(), RoundingMode.DOWN);
  }

  public BigDecimal calculate(Operation operation){
    BigDecimal result = BigDecimal.ZERO;
    switch (operation.getArithmeticOperator()){
      case SUM -> result = addBasicValues(operation.getValue1(),operation.getValue2());
      case SUB -> result = subtractBasicValues(operation.getValue1(),operation.getValue2());
      case MULTI -> result = multiplyBasicValues(operation.getValue1(),operation.getValue2());
      case DIV -> result = divideBasicValues(operation.getValue1(),operation.getValue2());
    }
    return unitConverter.getUnitValue(result, operation.getUnit()).setScale(2, RoundingMode.DOWN);
  }

  public CalculatorService(UnitConverter unitConverter) {
    this.unitConverter = unitConverter;
  }
}
