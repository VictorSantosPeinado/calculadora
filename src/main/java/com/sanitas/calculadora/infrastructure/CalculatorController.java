package com.sanitas.calculadora.infrastructure;

import com.sanitas.calculadora.application.CalculatorService;
import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    private TracerImpl tracer;

    @GetMapping("/calculate")
    public ResponseEntity<BigDecimal> calcular(@RequestParam BigDecimal firstOperator,
                                               @RequestParam BigDecimal secondOperator,
                                               @RequestParam String operation) {

        BigDecimal result = calculatorService.calculate(firstOperator, secondOperator, operation);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }

}
