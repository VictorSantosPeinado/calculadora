package com.sanitas.calculadora;

import com.sanitas.calculadora.application.OpType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculadoraApplicationTests {

    @LocalServerPort
    int serverPort;


    private ResponseEntity<BigDecimal> calculate(double firsOperator, double secondOperator, String operacion) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + serverPort +
                "/api/calculate?firstOperator=" + firsOperator +
                "&secondOperator=" + secondOperator + "&operation=" + operacion;
        URI uri = new URI(baseUrl);

        ResponseEntity<BigDecimal> result = restTemplate.getForEntity(uri, BigDecimal.class);
        return result;
    }

    @Test
    public void addition_success() throws URISyntaxException {

        ResponseEntity<BigDecimal> result = calculate(4.2, 8.3, OpType.ADDITION.name());

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(new BigDecimal(12.5), result.getBody());
    }

    @Test
    public void substraction_success() throws URISyntaxException {

        ResponseEntity<BigDecimal> result = calculate(14.8, 8.3, OpType.SUBSTRACTION.name());

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(new BigDecimal(6.5), result.getBody());
    }

    @Test
    public void operation_fail() throws URISyntaxException {

        ResponseEntity<BigDecimal> result = calculate(14.8, 8.3, "XXX");

        Assert.assertEquals(204, result.getStatusCodeValue());
        Assert.assertNull(result.getBody());
    }

}
