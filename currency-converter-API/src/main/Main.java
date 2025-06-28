package main;

public class Main {
    public static void main(String[] args) {
        ExchangeRateService service = new ExchangeRateService();
        CurrencyConverterUI converterUI = new CurrencyConverterUI(service);
        converterUI.start();
    }
}