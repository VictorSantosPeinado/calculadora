package com.sanitas.calculadora.application;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal calculate(BigDecimal firstOperator, BigDecimal secondOperator, String operationType) {

        try {
            OpType op = null;
            if (Arrays.stream(OpType.values()).anyMatch(x -> x.toString().equals(operationType))) {
                op = OpType.valueOf(operationType);
            }

            if (firstOperator != null && secondOperator != null && op != null) {
                switch (op) {
                    case ADDITION:
                        return firstOperator.add(secondOperator);
                    case SUBSTRACTION:
                        return firstOperator.subtract(secondOperator);
                }
            }
        } catch (Exception ex) {

        }

        return null;
    }

}
