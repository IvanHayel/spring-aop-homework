package by.teachmeskills.console;

import by.teachmeskills.service.CalculationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CalculationAction {
    private final ConsoleWriter writer;
    private final ConsoleReader reader;
    private final CalculationService calcService;

    public void run() {
        writer.writeString("Please, enter first number: ");
        double a = reader.readDouble();
        writer.writeString("Please, enter second number: ");
        double b = reader.readDouble();
        writer.writeString("Please, enter operation: ");
        String operation = reader.readString();
        writer.writeString("Result: " + calcService.calc(a, b, operation));
    }
}