
Open terminal and execute:

```
git clone https://github.com/VictorSantosPeinado/calculadora.git
cd calculadora
mvn validate
mvn clean install
java -jar target/calculadora-0.0.1-SNAPSHOT.jar
```



* GET `http://localhost:8080/api/calculate?firstOperator={firstOperator}&secondOperator={secondOperator}&operation={operation}`

Operations can be:
 - ADDITION
 - SUBSTRACTION
