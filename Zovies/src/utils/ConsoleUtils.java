package utils;

import java.util.Scanner;

public class ConsoleUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static void write(String line) {
        System.out.println(line);
    }
    
    public static String read() {
        return scanner.nextLine();
    }
}
