package model;

import java.io.Serializable;

public class InvoiceItem implements Serializable {
    private Shoe shoe;
    private int quantity;

    public InvoiceItem(Shoe shoe, int quantity) {
        this.shoe = shoe;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return shoe.getPrice() * quantity;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public int getQuantity() {
        return quantity;
    }
}
