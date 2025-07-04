# 💱 Currency Converter Application

Welcome to the **Currency Converter** application — a simple Java-based tool that allows you to convert between currencies using real-time exchange rates from an external API called exchangerate-api.

## 📋 Menu Options

When you run the program, you will see the following options:

```bash
=== CURRENCY CONVERTER ===
1. Show Exchange Rates
2. Convert Currency
3. Exit
Select option:
```

## 🚀 Features

- Converts currencies using **live exchange rates**
- Friendly and interactive terminal interface
- Supports the following conversions:
  - USD ⇄ ARS
  - USD ⇄ BRL
  - USD ⇄ COP
     
    and more!!!
- Clean code architecture and reusable functions

## 🛠 Technologies Used

- **Java 17+**
- **API** ([ExchangeRate-API](https://www.exchangerate-api.com/))
- **Gson** for JSON parsing

## 🔧 Setup & Installation

1. **Clone the repository:**

```bash
   git clone https://github.com/VivianaMolina/My-Java-Projects/currency-converter-api.git
   cd currency-converter-java
```

## Run the application
```bash
java -jar target/currency-converter.jar
```

## Set your API key

Add your API key to a config file or environment variable (depending on implementation).

## Example of API integration

GET https://api.exchangerate-api.com/v4/latest/USD


## Example of use
```bash
Choose a valid option: 2 
Enter source currency: USD
Enter target currency: EUR
Enter amount: 10

10,00 USD = 8,54 EUR
Rate date: Sat, 28 Jun 2025 00:00:01 +0000
```
## Json file generated
```json
[
  {
    "timestamp": "2025-06-28 00:11:16",
    "amount": 10.0,
    "fromCurrency": "USD",
    "toCurrency": "EUR",
    "result": 8.541
  }
]
```



