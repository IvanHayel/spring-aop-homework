package by.teachmeskills.console;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter {
    public void writeString(String str) {
        System.out.println(str);
    }
}
