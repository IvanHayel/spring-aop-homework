package by.teachmeskills.aspect;


import org.aspectj.lang.annotation.Pointcut;

public class CalculatorPointcuts {
    private CalculatorPointcuts() {
    }

    @Pointcut("@annotation(by.teachmeskills.annotation.Logging)")
    public void loggingAnnotatedPointcut() {
    }

    @Pointcut("@annotation(by.teachmeskills.annotation.Benchmark)")
    public void benchmarkAnnotatedPointcut() {
    }

    @Pointcut("execution(* by.teachmeskills.console.CalculationAction.*(..))")
    public void calculationPointcut() {
    }
}