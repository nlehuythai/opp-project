package store;

import model.Invoice;
import model.InvoiceItem;

import java.io.*;
import java.util.ArrayList;

public class InvoiceManager {
    private ArrayList<Invoice> invoices = new ArrayList<>();
    private final String folder = "data/invoices/";

    public InvoiceManager() {
        File f = new File(folder);
        if (!f.exists())
            f.mkdirs();
        loadInvoices();
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
        exportInvoice(invoice);
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    private void loadInvoices() {
        File f = new File(folder);
        File[] files = f.listFiles();
        if (files != null) {
            for (File file : files) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    Invoice inv = (Invoice) ois.readObject();
                    invoices.add(inv);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void exportInvoice(Invoice invoice) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(folder + "invoice_" + invoice.getId() + ".dat"));
            oos.writeObject(invoice);
            oos.close();

            // Xuất thêm txt cho dễ xem
            BufferedWriter bw = new BufferedWriter(new FileWriter(folder + "invoice_" + invoice.getId() + ".txt"));
            bw.write("===== INVOICE #" + invoice.getId() + " =====\n");
            bw.write("Date: " + invoice.getDate() + "\n\n");
            for (InvoiceItem item : invoice.getItems()) {
                bw.write(item.getShoe().getName() + " x" + item.getQuantity() + " = " + item.getSubtotal() + "\n");
            }
            bw.write("\nTotal: " + invoice.getTotal());
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
