package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice implements Serializable {
    private int id;
    private LocalDate date;
    private ArrayList<InvoiceItem> items = new ArrayList<>();

    public Invoice(int id) {
        this.id = id;
        this.date = LocalDate.now();
    }

    public void addItem(InvoiceItem item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream().mapToDouble(InvoiceItem::getSubtotal).sum();
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<InvoiceItem> getItems() {
        return items;
    }
}
