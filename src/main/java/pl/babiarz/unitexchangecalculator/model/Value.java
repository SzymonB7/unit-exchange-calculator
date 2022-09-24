package pl.babiarz.unitexchangecalculator.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Value {
  private BigDecimal number;
  private Unit unit;

}
