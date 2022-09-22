package pl.babiarz.unitexchangecalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;



public class Calculator {
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

  public BigDecimal calculate(Value value1, Value value2, Operator operator, Unit unit){
    BigDecimal result = BigDecimal.ZERO;
    switch (operator){
      case SUM -> result = addBasicValues(value1,value2);
      case SUB -> result = subtractBasicValues(value1,value2);
      case MULTI -> result = multiplyBasicValues(value1,value2);
      case DIV -> result = divideBasicValues(value1,value2);
    }
    return unitConverter.getUnitValue(result, unit).setScale(2, RoundingMode.DOWN);
  }

  public Calculator(UnitConverter unitConverter) {
    this.unitConverter = unitConverter;
  }
}
