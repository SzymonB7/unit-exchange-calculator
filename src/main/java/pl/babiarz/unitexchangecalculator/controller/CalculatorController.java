package pl.babiarz.unitexchangecalculator.controller;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.babiarz.unitexchangecalculator.model.Calculation;
import pl.babiarz.unitexchangecalculator.service.CalculatorService;

@RequestMapping(value = "/api/calculator")
@RestController
@AllArgsConstructor
public class CalculatorController {
  private final CalculatorService calculatorService;

  @PostMapping(path = "/calculate")
  public BigDecimal calculateValuesInUnit(@RequestBody Calculation calculation) {
    return calculatorService.calculate(calculation);
  }

}
