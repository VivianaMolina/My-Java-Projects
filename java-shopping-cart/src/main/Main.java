package main;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner lectureScanner = new Scanner(System.in);
        System.out.println("Type the card limit: ");
        double limit = lectureScanner.nextDouble();
        CreditCard card = new CreditCard(limit);

        int exit = 1;
        while(exit != 0) {
            System.out.println("Type the purchase description:");
            String descripcion = lectureScanner.next();

            System.out.println("Type the purchase amount:");
            double valor = Double.valueOf(lectureScanner.next());

            Purchase item = new Purchase(valor, descripcion);
            boolean purchaseOrderClosure = card.lanzarCompra(item);

            if (purchaseOrderClosure) {
                System.out.println("Item added!");
                System.out.println("Type 0 to exit or 1 to continue");
                exit = lectureScanner.nextInt();
            } else {
                System.out.println("The balance on your card is insufficient to add this product.");
                exit = 0;
            }
        }
        System.out.println("***********************");
        System.out.println("Order Details:\n");
        Collections.sort(card.getshoppingCart());
        for (Purchase item : card.getshoppingCart()) {
            System.out.println(item.getdescription() + " - " +item.getvalue());
        }
        System.out.println("\n***********************");
        System.out.println("\nCard balance: " +card.getbalance());
    }

    
}
