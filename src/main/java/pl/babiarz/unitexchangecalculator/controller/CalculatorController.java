package pl.babiarz.unitexchangecalculator.controller;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.babiarz.unitexchangecalculator.model.Calculation;
import pl.babiarz.unitexchangecalculator.model.Value;
import pl.babiarz.unitexchangecalculator.service.CalculatorService;

@RequestMapping
@RestController
@AllArgsConstructor
public class CalculatorController {
  private final CalculatorService calculatorService;

  @PostMapping
  public BigDecimal calculateTaxes(@RequestBody Calculation calculation) {
    return calculatorService.calculate(calculation);
  }


//  @GetMapping("/")
//  public String getForm(Model model, Calculation calculation){
//    Value value1 = new Value();
//    Value value2 = new Value();
//
//    model.addAttribute("calculation", new Calculation());
//    return "form";
//  }
//  @PostMapping
//  public String getUnitResult (@ModelAttribute Calculation calculation, Model model){
//    model.addAttribute("result", calculatorService.calculate(calculation));
//    return "form";
//  }

}
