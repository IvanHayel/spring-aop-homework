package by.teachmeskills.service;

import by.teachmeskills.annotation.Benchmark;
import by.teachmeskills.annotation.Logging;
import org.springframework.stereotype.Component;

@Component
public class CalculationService {
    @Benchmark
    @Logging
    public Double calc(double a, double b, String operation) {
        switch (operation) {
            case "sum":
                return a + b;
            case "sub":
                return a - b;
            case "mul":
                return a * b;
            case "div":
                return a / b;
            default:
                return Double.NaN;
        }
    }
}
