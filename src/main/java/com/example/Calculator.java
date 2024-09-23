package com.example;
import java.util.Scanner;


public class Calculator {

    // Square root function: √x
    public static double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Square root of a negative number is not defined.");
        }
        return Math.sqrt(x);
    }

    // Factorial function: x!
    public static long factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Factorial of a negative number is not defined.");
        }
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    // Natural logarithm function: ln(x)
    public static double naturalLog(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Natural logarithm is only defined for positive numbers.");
        }
        return Math.log(x);
    }

    // Power function: x^b
    public static double power(double x, double b) {
        return Math.pow(x, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power Function (x^b)");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Square Root
                    System.out.print("Enter a number to find the square root: ");
                    double sqrtInput = scanner.nextDouble();
                    try {
                        System.out.println("Square root of " + sqrtInput + " is " + squareRoot(sqrtInput));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2: // Factorial
                    System.out.print("Enter an integer to find the factorial: ");
                    int factInput = scanner.nextInt();
                    try {
                        System.out.println("Factorial of " + factInput + " is " + factorial(factInput));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3: // Natural Logarithm
                    System.out.print("Enter a number to find the natural logarithm: ");
                    double logInput = scanner.nextDouble();
                    try {
                        System.out.println("Natural logarithm of " + logInput + " is " + naturalLog(logInput));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4: // Power Function
                    System.out.print("Enter the base (x): ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter the exponent (b): ");
                    double exponent = scanner.nextDouble();
                    System.out.println(base + " raised to the power of " + exponent + " is " + power(base, exponent));
                    break;

                case 5: // Exit
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}
