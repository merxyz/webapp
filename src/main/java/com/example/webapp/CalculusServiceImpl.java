package com.example.webapp;

import com.expression.parser.Parser;
import org.springframework.stereotype.Service;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Base64;

@ThreadSafe
@Service
public class CalculusServiceImpl implements CalculusService {
    public Double calculate(String encodedExpression) {
        try {
            String decodedExpression = new String(Base64.getDecoder().decode(encodedExpression));
            return Parser.eval(decodedExpression).getValue();
        } catch (Exception e) {
            return null;
        }
    }
}
