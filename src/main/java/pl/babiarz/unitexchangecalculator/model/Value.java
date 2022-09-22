package pl.babiarz.unitexchangecalculator.model;

import java.math.BigDecimal;


public class Value {
  private BigDecimal number;
  private Unit unit;


  public Value(BigDecimal number, Unit unit) {
    this.number = number;
    this.unit = unit;
  }
  public BigDecimal getBasicValue() {
    return switch (unit) {
      case m -> number;
      case ft -> number.multiply(BigDecimal.valueOf(0.3048));
      case NM -> number.multiply(BigDecimal.valueOf(1852));
    };
  }



  public BigDecimal getNumber() {
    return number;
  }

  public Unit getUnit() {
    return unit;
  }

  public void setNumber(BigDecimal number) {
    this.number = number;
  }

  public void setUnit(Unit unit) {
    this.unit = unit;
  }
}
