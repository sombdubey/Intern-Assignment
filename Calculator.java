import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static final String SAVE_FILE = "calculations.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Load previous calculations from file
        List<String> previousCalculations = loadCalculations();

        // Display previous calculations
        System.out.println("Previous calculations:");
        for (String calculation : previousCalculations) {
            System.out.println(calculation);
        }
        System.out.println();

        // Prompt user for input
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter operation (+, -, *, /, ^, %): ");
        char operation = scanner.next().charAt(0);

        double result = 0;

        // Perform calculation based on operation
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero!");
                    return; // Exit the program if division by zero occurs
                }
                break;
            case '^':
                result = Math.pow(num1, num2);
                break;
            case '%':
                result = num1 % num2;
                break;
            default:
                System.out.println("Error: Invalid operation!");
                return; // Exit the program if an invalid operation is entered
        }

        // Save the calculation to file
        String calculation = num1 + " " + operation + " " + num2 + " = " + result;
        saveCalculation(calculation);

        // Display result
        System.out.println("Result: " + result);

        // Close the scanner
        scanner.close();
    }

    private static List<String> loadCalculations() {
        List<String> calculations = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                calculations.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading calculations from file: " + e.getMessage());
        }
        return calculations;
    }

    private static void saveCalculation(String calculation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE, true))) {
            writer.write(calculation);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving calculation to file: " + e.getMessage());
        }
    }
}


