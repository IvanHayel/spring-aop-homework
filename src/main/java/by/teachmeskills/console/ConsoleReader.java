package by.teachmeskills.console;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleReader {
    private static final Scanner KEYBOARD = new Scanner(System.in);

    public String readString() {
        return KEYBOARD.nextLine();
    }

    public double readDouble() {
        double doubleValue = Double.NaN;
        try {
            doubleValue = Double.parseDouble(KEYBOARD.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("The entered value doesn't match the double type! Try again:");
            return readDouble();
        }
        return doubleValue;
    }
}
