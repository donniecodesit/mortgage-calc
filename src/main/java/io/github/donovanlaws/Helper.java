package io.github.donovanlaws;

import java.util.Scanner;

public class Helper {
    public static boolean isValidNumber(String input, String type, int min, int max){
        boolean validValue = false;

        if (type.equals("int")) {
            boolean valid = input.matches("\\d+");
            if (valid) validValue = (Integer.parseInt(input) >= min && Integer.parseInt(input) <= max);
            if (!validValue) System.out.println("Input a valid number between " + min + " and " + max + ".");
        }
        else if (type.equals("float")) {
            boolean valid = input.matches("\\d+\\.\\d+");
            if (valid) validValue = (Float.parseFloat(input) >= (float) min && Float.parseFloat(input) <= (float) max);
            if (!validValue) System.out.println("Input a valid number between " + min + ".00 and " + max + ".00.");
        }

        return validValue;
    }

    public static int parsePrincipal(Scanner scanner) {
        while (true) {
            System.out.print("Loan Principal ($1K - $1M): ");
            String principalInput = scanner.nextLine();
            if (!isValidNumber(principalInput, "int", 1_000, 1_000_000)) continue;

            int principal = Integer.parseInt(principalInput);
            if (principal >= 1000 && principal <= 1_000_000) return principal;
        }
    }

    public static float parseInterest(Scanner scanner, int PERCENT, int MONTHS_IN_YEAR) {
        while (true) {
            System.out.print("Annual Interest Rate (1.00 - 30.00) Percent: ");
            String interestInput = scanner.nextLine();
            if (!isValidNumber(interestInput, "float", 1, 30)) continue;

            float annualInterest = Float.parseFloat(interestInput);
            if (annualInterest >= 1 && annualInterest <= 30) {
                return annualInterest / PERCENT / MONTHS_IN_YEAR;
            }
        }
    }

    public static int parsePayments(Scanner scanner, int MONTHS_IN_YEAR) {
        while (true) {
            System.out.print("Period (1 - 30) Years: ");
            String periodInput = scanner.nextLine();
            if (!isValidNumber(periodInput, "int", 1, 30)) continue;

            byte years = Byte.parseByte(periodInput);
            if (years >= 1 && years <= 30) {
                return years * MONTHS_IN_YEAR;
            }
        }
    }

    public static double calculateMortgage(int principal, float monthlyInterest, int numberOfPayments) {
        return
                principal
                        * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
