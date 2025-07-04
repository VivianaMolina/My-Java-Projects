**"Java: Working with Lists and Collections of Data"**

# Credit Card Purchase Manager (Java Project)

This Java project focuses on class modeling and application structure. It simulates a credit card system where users can register and manage purchases using object-oriented programming principles.

## Project Overview

The core class, `CreditCard`, includes three attributes:
- `limit`: the credit limit assigned to the card.
- `balance`: the current available balance.
- `purchaseList`: a list of `Purchase` objects representing each transaction.

A `Purchase` class is implemented with two fields:
- `amount`: the value of the purchase.
- `description`: a brief description of the item or service.

Constructors and getters are provided for both classes. Notably, no setters are included for `limit` and `balance`, preserving the integrity of the card’s internal state.

The `makePurchase` method checks if a new purchase can be completed with the available balance. If so, it updates the balance and adds the purchase to the list.

## Application Flow

The `Main` class contains the user interface logic via the `main` method. A loop enables the user to continue adding purchases until they opt to stop. At the end of the session, the program displays a summary of all registered purchases and the remaining credit limit.

## Sorting Functionality

The project leverages `Collections.sort()` to arrange the purchase list by amount. To support this, the `Purchase` class implements the `Comparable` interface, overriding the `compareTo` method. Because `double` is a primitive type, it is converted to the `Double` wrapper class to use the built-in comparison features.

## Learning Objectives

- Apply Java class modeling and encapsulation techniques.
- Use lists and collections to manage data.
- Implement custom logic in constructors and methods.
- Enable object sorting using `Comparable` and `Collections.sort`.
- Build a functional command-line interface in Java.
