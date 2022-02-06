package com.sanitas.calculadora.application;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface CalculatorService {

	public BigDecimal calculate(BigDecimal firstOperator,
					 			BigDecimal secondOperator,
					 			OpType operationType);

	
}
