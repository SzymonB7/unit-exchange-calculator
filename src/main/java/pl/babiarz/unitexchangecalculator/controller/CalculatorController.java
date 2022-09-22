package pl.babiarz.unitexchangecalculator.controller;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.babiarz.unitexchangecalculator.model.Operation;
import pl.babiarz.unitexchangecalculator.service.CalculatorService;

@RequestMapping
@RestController
@AllArgsConstructor
public class CalculatorController {
  private final CalculatorService calculatorService;

  @PostMapping
  public BigDecimal getUnitResult (@RequestBody Operation operation){
    return calculatorService.calculate(operation);
  }

}
