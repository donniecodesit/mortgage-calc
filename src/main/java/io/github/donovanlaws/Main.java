package io.github.donniecodesit;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MONTHS_IN_YEAR = 12;
        final int PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        int principal = Helper.parsePrincipal(scanner);
        float monthlyInterest = Helper.parseInterest(scanner, PERCENT, MONTHS_IN_YEAR);
        int numberOfPayments = Helper.parsePayments(scanner, MONTHS_IN_YEAR);

        System.out.println("Principal: " + principal + ", Interest: " + monthlyInterest + ", Payments: " + numberOfPayments);
        double mortgage = Helper.calculateMortgage(principal, monthlyInterest, numberOfPayments);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
