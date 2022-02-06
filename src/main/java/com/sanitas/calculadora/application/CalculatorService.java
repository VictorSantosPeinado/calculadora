package com.sanitas.calculadora.application;

import java.math.BigDecimal;

public interface CalculatorService {

	public BigDecimal calculate(BigDecimal firstOperator,
					 			BigDecimal secondOperator,
					 			String operationType);

	
}
