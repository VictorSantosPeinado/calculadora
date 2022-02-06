package com.sanitas.calculadora.application;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal calculate(BigDecimal firstOperator, BigDecimal secondOperator, OpType operationType) {
        if (firstOperator != null && secondOperator != null && operationType != null) {
            switch (operationType) {
                case ADDITION:
                    return firstOperator.add(secondOperator);
                case SUBSTRACTION:
                    return firstOperator.subtract(secondOperator);
            }
        }
        return null;
    }

}
