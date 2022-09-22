package pl.babiarz.unitexchangecalculator.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import pl.babiarz.unitexchangecalculator.model.Unit;

@Service
public class UnitConverter {
  public BigDecimal getUnitValue(BigDecimal basicValue, Unit unit){
    return switch (unit){
      case m -> basicValue.multiply(BigDecimal.ONE);
      case NM -> basicValue.multiply(BigDecimal.valueOf(0.000539956803));
      case ft -> basicValue.multiply(BigDecimal.valueOf(3.2808399));
    };
  }
}
