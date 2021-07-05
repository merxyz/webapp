package com.example.webapp;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CalculusRestApiTest {

    @Test
    public void getCalculusResponse() {
        CalculusRestApi apiService = new CalculusRestApi();
        String encodedExpression = "MiAqICgyMy8oMyozKSktIDIzICogKDIqMyk=";
        ResponseEntity<CalculusResponse> result = apiService.getCalculusResponse(encodedExpression);
        assert (result.getStatusCode() == HttpStatus.OK);
        assert (result.getBody().result == -132.88888888888889);

        String encodedExpression2 = "MiAqICgyMy8oMyozKSktIDIzICogKDIqMyk=";
        ResponseEntity<CalculusResponse> result2 = apiService.getCalculusResponse(encodedExpression2);
        assert (result2.getStatusCode() == HttpStatus.OK);
        assert (result2.getBody().result == -132.88888888888889);

        String incorrectInput = "This is an incorrect input";
        ResponseEntity<CalculusResponse> result3 = apiService.getCalculusResponse(incorrectInput);
        System.out.println(result3.getBody());
        assert (result3.getStatusCode() == HttpStatus.BAD_REQUEST);
    }
}