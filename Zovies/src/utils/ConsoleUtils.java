package utils;

import java.util.Scanner;

public class ConsoleUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static void writeConsoleLine(String line) {
        System.out.println(line);
    }
    
    public static String readConsoleLine() {
        return scanner.nextLine();
    }
}
