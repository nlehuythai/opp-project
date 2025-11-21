package OPP_project.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice {
    private String invoiceId;
    private LocalDate date;
    private Customer customer;
    private ArrayList<InvoiceItem> items = new ArrayList<>();

    public Invoice() {
    }

    public Invoice(String invoiceId, LocalDate date, Customer customer) {
        this.invoiceId = invoiceId;
        this.date = date;
        this.customer = customer;
    }

    public void addItem(InvoiceItem item) {
        items.add(item);
    }

    public double getTotal() {
        double sum = 0;
        for (InvoiceItem item : items)
            sum += item.getSubtotal();
        return sum;
    }

    // GETTER – SETTER
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<InvoiceItem> items) {
        this.items = items;
    }
}
