package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Calculator {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
/*
        System.out.println("Enter number: ");
        long number = sc.nextLong();

        FizzBuzz fizzBuzz = new FizzBuzz();

        fizzBuzz.fizzBuzz(number);
*/
//  CALCULATOR

        Maths maths = new Maths();

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        System.out.println("Enter number: ");
        double number1 = sc.nextDouble();

        String operator = "";
        double result = 0;
        double number2 = 0;

        while (!operator.equals("=")) {

            System.out.println("Enter operator: ");

            operator = reader.readLine();

            if (operator.equals("=")) {
                System.out.println("Result = " + result);
                break;
            }

            System.out.println("Enter number: ");
            number2 = sc.nextDouble();

            result = 0;
            switch (operator) {
                case "+":
                    result = Maths.add(number1, number2);
                    break;
                case "-":
                    result = Maths.subtract(number1, number2);
                    break;
                case "*":
                    result = Maths.multiply(number1, number2);
                    break;
                case "/":
                    result = Maths.divide(number1, number2);
                    break;
                case "=":
                    System.out.println("Result = " + result);
                    break;
                default:
                    System.out.println("Wrong operator");
                    sc.close();
            }

            number1 = result;
            //System.out.println("Result = " + result);
        }

    }

}