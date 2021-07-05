package com.example.webapp;

import org.junit.jupiter.api.Test;

public class CalculusServiceImplTest {

    @Test
    public void calculate(){
        CalculusServiceImpl service = new CalculusServiceImpl();
        String encodedExpression = "MiAqICgyMy8oMyozKSktIDIzICogKDIqMyk=";
        Double result = service.calculate(encodedExpression);
        assert(result == -132.88888888888889);

        String encodedExpression2 = "MiooMjMvOSktMjMqNg==";
        Double result2 = service.calculate(encodedExpression2);
        assert(result2 == -132.88888888888889);

        String incorrectInput = "This is an incorrect input";
        Double result3 = service.calculate(incorrectInput);
        assert(result3 == null);
    }
}