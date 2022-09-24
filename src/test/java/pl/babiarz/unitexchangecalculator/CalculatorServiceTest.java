package pl.babiarz.unitexchangecalculator;

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.babiarz.unitexchangecalculator.model.ArithmeticOperator;
import pl.babiarz.unitexchangecalculator.model.Calculation;
import pl.babiarz.unitexchangecalculator.model.Unit;
import pl.babiarz.unitexchangecalculator.model.Value;
import pl.babiarz.unitexchangecalculator.service.CalculatorService;
import pl.babiarz.unitexchangecalculator.service.UnitConverter;

class CalculatorServiceTest {
  UnitConverter unitConverter = new UnitConverter();
  CalculatorService calculatorService = new CalculatorService(unitConverter);
  @ParameterizedTest
  @CsvSource(value = {"13:15:91184.38", "-5:5:30364.17","150.25:1000:6076608.43"}, delimiter = ':')
  void shouldAddTwoValuesAndGetResultInFeet(BigDecimal number1, BigDecimal number2, BigDecimal expected){
    //given
    Value value1 = new Value(number1, Unit.m);
    Value value2 = new Value(number2, Unit.NM);
    Calculation calculation = new Calculation(value1, value2, ArithmeticOperator.SUM, Unit.ft);
    //when
    BigDecimal result = calculatorService.calculate(calculation);
    //then
    Assertions.assertEquals(expected, result);
  }
  @ParameterizedTest
  @CsvSource(value = {"13:15:110075.47", "-5:5:-14112.24","150.25:1000:84814562.40"}, delimiter = ':')
  void shouldMultiplyTwoValuesAndGetResultInFeet(BigDecimal number1, BigDecimal number2, BigDecimal expected){
    //given
    Value value1 = new Value(number1, Unit.ft);
    Value value2 = new Value(number2, Unit.NM);
    Calculation calculation = new Calculation(value1, value2, ArithmeticOperator.MULTI, Unit.m);
    //when
    BigDecimal result = calculatorService.calculate(calculation);
    //then
    Assertions.assertEquals(expected, result);
  }
  @ParameterizedTest
  @CsvSource(value = {"13:15:12.99", "-5:5:-5.00","150.25:1000:149.71"}, delimiter = ':')
  void shouldSubtractTwoValuesAndGetResultInFeet(BigDecimal number1, BigDecimal number2, BigDecimal expected){
    //given
    Value value1 = new Value(number1, Unit.NM);
    Value value2 = new Value(number2, Unit.m);
    Calculation calculation = new Calculation(value1, value2, ArithmeticOperator.SUB, Unit.NM);
    //when
    BigDecimal result = calculatorService.calculate(calculation);
    //then
    Assertions.assertEquals(expected, result);
  }
  @ParameterizedTest
  @CsvSource(value = {"13:15:1605.06", "-5:5:-1851.99","150.25:1000:278.26"}, delimiter = ':')
  void shouldDivideTwoValuesAndGetResultInFeet(BigDecimal number1, BigDecimal number2, BigDecimal expected){
    //given
    Value value1 = new Value(number1, Unit.NM);
    Value value2 = new Value(number2, Unit.m);
    Calculation calculation = new Calculation(value1, value2, ArithmeticOperator.DIV, Unit.ft);
    //when
    BigDecimal result = calculatorService.calculate(calculation);
    //then
    Assertions.assertEquals(expected, result);
  }

}