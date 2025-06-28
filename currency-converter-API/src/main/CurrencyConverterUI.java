package main;

import java.util.Scanner;

import models.ExchangeRateResponse;

public class CurrencyConverterUI {
    private final ExchangeRateService service;
    private final Scanner scanner;
    private final FileGenerator logger = new FileGenerator();

    public CurrencyConverterUI(ExchangeRateService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            handleChoice(choice);
        } while(choice != 3);
    }

    private void printMenu() {
        System.out.println("\n=== CURRENCY CONVERTER ===");
        System.out.println("1. Show Exchange Rates");
        System.out.println("2. Convert Currency");
        System.out.println("3. Exit");
        System.out.print("Select option: ");
    }

    private void handleChoice(int choice) {
        try {
            switch(choice) {
                case 1 -> showRates();
                case 2 -> convertCurrency();
                case 3 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void showRates() throws Exception {
        ExchangeRateResponse response = service.fetchLatestRates();
        System.out.println("\nLast Update: " + response.time_last_update_utc());
        System.out.println("Base Currency: " + response.base_code());
        
        response.conversion_rates().forEach((currency, rate) -> 
            System.out.printf("%-6s: %.4f%n", currency, rate));
    }

    private void convertCurrency() throws Exception {
        System.out.print("\nEnter source currency: ");
        String from = scanner.next();
        
        System.out.print("Enter target currency: ");
        String to = scanner.next();
        
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        
        double result = service.convert(amount, from, to);
        System.out.printf("\n%.2f %s = %.2f %s%n", amount, from.toUpperCase(), result, to.toUpperCase());
        System.out.println("Rate date: " + service.getLastUpdateTime());
        logger.saveJson(amount, from, to, result);
    }
}