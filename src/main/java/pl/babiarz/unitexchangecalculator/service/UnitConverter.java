package pl.babiarz.unitexchangecalculator.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import pl.babiarz.unitexchangecalculator.model.Unit;
import pl.babiarz.unitexchangecalculator.model.Value;

@Service
public class UnitConverter {
  public BigDecimal getUnitValue(Value value, Unit unit){
    return switch (value.getUnit()){
      case m -> switch(unit){
        case m -> value.getNumber().multiply(BigDecimal.ONE);
        case NM -> value.getNumber().multiply(BigDecimal.valueOf(0.000539956803));
        case ft -> value.getNumber().multiply(BigDecimal.valueOf(3.2808399));
      };
      case NM -> switch(unit){
        case m -> value.getNumber().multiply(BigDecimal.valueOf(1852));
        case NM -> value.getNumber().multiply(BigDecimal.ONE);
        case ft -> value.getNumber().multiply(BigDecimal.valueOf(6076.11549));
      };
      case ft -> switch(unit){
        case m -> value.getNumber().multiply(BigDecimal.valueOf(0.3048));
        case NM -> value.getNumber().multiply(BigDecimal.valueOf(0.000164578834));
        case ft -> value.getNumber().multiply(BigDecimal.ONE);
      };
    };
  }
}
