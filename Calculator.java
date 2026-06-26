import java.util.Scanner;

/**
 * A simple command-line calculator that performs basic arithmetic operations.
 * Supports addition, subtraction, multiplication, and division.
 */
public class Calculator {
    
    /**
     * Performs addition of two numbers
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public static double add(double a, double b) {
        return a + b;
    }
    
    /**
     * Performs subtraction of two numbers
     * @param a first number
     * @param b second number
     * @return difference of a and b
     */
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    /**
     * Performs multiplication of two numbers
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    /**
     * Performs division of two numbers
     * @param a first number (dividend)
     * @param b second number (divisor)
     * @return quotient of a divided by b
     * @throws ArithmeticException if b is zero
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }
    
    /**
     * Displays the menu of available operations
     */
    public static void displayMenu() {
        System.out.println("\n===== Simple Calculator =====");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Exit");
        System.out.println("=============================");
    }
    
    /**
     * Main method to run the calculator
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;
        
        System.out.println("Welcome to the Simple Calculator!");
        
        while (continueCalculating) {
            displayMenu();
            System.out.print("Enter your choice (1-5): ");
            
            String choice = scanner.nextLine().trim();
            
            if (choice.equals("5")) {
                System.out.println("Thank you for using the calculator. Goodbye!");
                continueCalculating = false;
                break;
            }
            
            if (!choice.matches("[1-4]")) {
                System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                continue;
            }
            
            try {
                System.out.print("Enter first number: ");
                double num1 = Double.parseDouble(scanner.nextLine());
                
                System.out.print("Enter second number: ");
                double num2 = Double.parseDouble(scanner.nextLine());
                
                double result = 0;
                String operation = "";
                
                switch (choice) {
                    case "1":
                        result = add(num1, num2);
                        operation = "Addition";
                        break;
                    case "2":
                        result = subtract(num1, num2);
                        operation = "Subtraction";
                        break;
                    case "3":
                        result = multiply(num1, num2);
                        operation = "Multiplication";
                        break;
                    case "4":
                        result = divide(num1, num2);
                        operation = "Division";
                        break;
                }
                
                System.out.println("\n--- Result ---");
                System.out.println(operation + ": " + num1 + " → Result: " + result);
                System.out.println("---------------\n");
                
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers!");
            }
        }
        
        scanner.close();
    }
}
