package com.example.webapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.concurrent.ThreadSafe;


@ThreadSafe
@RestController
public class CalculusRestApi {

    CalculusServiceImpl service = new CalculusServiceImpl();

    @RequestMapping(value = "/calculus", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CalculusResponse> getCalculusResponse(@RequestParam(name = "query") String query) {
        Double result = service.calculate(query);
        if (result == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new CalculusResponse(result), HttpStatus.OK);
    }
}
