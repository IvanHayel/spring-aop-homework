package by.teachmeskills.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class CalculatorAspect {
    @Before("by.teachmeskills.aspect.CalculatorPointcuts.loggingAnnotatedPointcut()")
    public void beforeLoggingStartAdvice() {
        log.info("loggingAnnotatedPointCut - Start");
    }

    @AfterReturning("by.teachmeskills.aspect.CalculatorPointcuts.loggingAnnotatedPointcut()")
    public void afterLoggingFinishAdvice() {
        log.info("loggingAnnotatedPointCut - Finish");
    }

    @Before("by.teachmeskills.aspect.CalculatorPointcuts.calculationPointcut()")
    public void beforeCalculationStartAdvice() {
        log.info("Start");
    }

    @AfterReturning("by.teachmeskills.aspect.CalculatorPointcuts.calculationPointcut()")
    public void afterCalculationFinishAdvice() {
        log.info("Finish");
    }

    @Around("by.teachmeskills.aspect.CalculatorPointcuts.benchmarkAnnotatedPointcut()")
    public Object aroundMethodWithBenchmarkAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime start = LocalDateTime.now();
        Object proceed = joinPoint.proceed();
        LocalDateTime end = LocalDateTime.now();
        long millisRequired = Duration.between(start, end).toMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getMethod().getName();
        log.info("{}.{}() took {} milliseconds", className, methodName, millisRequired);
        return proceed;
    }
}
