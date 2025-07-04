package main;

import java.util.ArrayList;
import java.util.List;

class CreditCard {
    private double limit;
    private double balance;
    private List<Purchase> shoppingCart;

    public CreditCard(double limit){
        this.limit = limit;
        this.balance = limit;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean lanzarCompra(Purchase item){
        if(this.balance >= item.getvalue()){
            this.balance -= item.getvalue();
            this.shoppingCart.add(item);
            return true;
        }
        return false;
    }

    public double getLimit() {
        return limit;
    }

    public double getbalance() {
        return balance;
    }

    public List<Purchase> getshoppingCart() {
        return shoppingCart;
    }


}