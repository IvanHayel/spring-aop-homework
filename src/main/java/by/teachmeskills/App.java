package by.teachmeskills;

import by.teachmeskills.config.RootConfig;
import by.teachmeskills.console.CalculationAction;
import lombok.Cleanup;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        @Cleanup
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
        CalculationAction calculationAction = context.getBean("calculationAction", CalculationAction.class);
        calculationAction.run();
    }
}
