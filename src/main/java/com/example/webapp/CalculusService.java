package com.example.webapp;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface CalculusService {

    public Double calculate(String encodedExpression);
}
