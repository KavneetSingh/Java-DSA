import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;

        System.out.println("Welcome to the Advanced Calculator!");
        System.out.println("Enter 'exit' to quit.");

        while (true) {
            System.out.print("Enter the expression (e.g., log, sin, cos, +, -, *, /): ");
            String expression = scanner.next();

            if (expression.equalsIgnoreCase("exit")) {
                System.out.println("Calculator is exiting. Goodbye!");
                break;
            }

            if (isArithmeticOperator(expression)) {
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                switch (expression) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            System.out.println("Cannot divide by zero!");
                            continue;
                        }
                        break;
                }
            } else if (isTrigonometricFunction(expression)) {
                System.out.print("Enter the angle in degrees: ");
                double angle = scanner.nextDouble();
                angle = Math.toRadians(angle);

                switch (expression) {
                    case "sin":
                        result = Math.sin(angle);
                        break;
                    case "cos":
                        result = Math.cos(angle);
                        break;
                    case "tan":
                        result = Math.tan(angle);
                        break;
                    case "cot":
                        result = 1 / Math.tan(angle);
                        break;
                }
            } else if (expression.equalsIgnoreCase("log")) {
                System.out.print("Enter the number for logarithm calculation: ");
                double num = scanner.nextDouble();
                result = Math.log(num);
            } else {
                System.out.println("Invalid expression! \n Please enter a valid expression (log, sin, cos, tan, cot, +, -, *, /).");
                continue;
            }

            System.out.println("Result: " + result);
        }

        scanner.close();
    }

    private static boolean isArithmeticOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    private static boolean isTrigonometricFunction(String function) {
        return function.equalsIgnoreCase("sin") || function.equalsIgnoreCase("cos")
                || function.equalsIgnoreCase("tan") || function.equalsIgnoreCase("cot");
    }
}
