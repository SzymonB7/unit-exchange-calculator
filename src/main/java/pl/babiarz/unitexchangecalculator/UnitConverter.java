package pl.babiarz.unitexchangecalculator;

import java.math.BigDecimal;


public class UnitConverter {
  public BigDecimal getUnitValue(BigDecimal basicNumber, Unit unit){
    return switch (unit){
      case m -> basicNumber.multiply(BigDecimal.ONE);
      case NM -> basicNumber.multiply(BigDecimal.valueOf(0.000539956803));
      case ft -> basicNumber.multiply(BigDecimal.valueOf(0.3048));
    };
  }
}
