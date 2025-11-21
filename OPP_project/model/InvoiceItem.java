package OPP_project.model;

public class InvoiceItem {
    private Shoe shoe;
    private int quantity;

    public InvoiceItem() {
    }

    public InvoiceItem(Shoe shoe, int quantity) {
        this.shoe = shoe;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return shoe.getPrice() * quantity;
    }

    // GETTER – SETTER
    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
