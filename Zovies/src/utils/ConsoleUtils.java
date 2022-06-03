package utils;

import java.util.Scanner;

import menus.ErrorMenu;

public class ConsoleUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static void writeLine(String line) {
        System.out.println(line);
    }
    
    public static void write(String line) {
        System.out.print(line);
    }
    
    public static void writeInteger(int number) {
        System.out.print(number);
    }
    
    public static void writeNewLine() {    
        System.out.println();
    }
    
    public static void clear() {
        for(int i = 0; i <= 30; i++) {
        	System.out.println();
        }
    }
    
    public static String read() {
        return scanner.nextLine();
    }
    
    public static int readInteger() {
    	
    	Integer result = null;
    	
    	while (result == null) {
			try {
				result = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				ErrorMenu.invalidInputError();
			}
		}  
    	return result;
    }
    
    public static double readDouble() {
    	
    	Double result = null;
    	
    	while (result == null) {
			try {
				result = Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				ErrorMenu.invalidInputError();
			}
		}  
    	return result;
    }
}
