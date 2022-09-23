package pl.babiarz.unitexchangecalculator;

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.babiarz.unitexchangecalculator.model.ArithmeticOperator;
import pl.babiarz.unitexchangecalculator.model.Calculation;
import pl.babiarz.unitexchangecalculator.model.Unit;
import pl.babiarz.unitexchangecalculator.model.Value;
import pl.babiarz.unitexchangecalculator.service.CalculatorService;
import pl.babiarz.unitexchangecalculator.service.UnitConverter;

class CalculatorServiceTest {
  UnitConverter unitConverter = new UnitConverter();
  CalculatorService calculatorService = new CalculatorService(unitConverter);
  @Test
  void shouldAddTwoValuesAndGetResultInFeet(){
    //given
    Value value1 = new Value(BigDecimal.valueOf(13), Unit.m);
    Value value2 = new Value(BigDecimal.valueOf(15), Unit.NM);
    Calculation calculation = new Calculation(value1, value2, ArithmeticOperator.SUM, Unit.ft);
    //when
    BigDecimal result = calculatorService.calculate(calculation);
    //then
    Assertions.assertEquals(BigDecimal.valueOf(91184.38), result);
  }
}