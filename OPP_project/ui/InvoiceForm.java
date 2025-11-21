package ui;

import model.Shoe;
import model.Invoice;
import model.InvoiceItem;
import store.ShoeStore;
import store.InvoiceManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class InvoiceForm extends JFrame {
    private ShoeStore store = new ShoeStore();
    private InvoiceManager manager = new InvoiceManager();
    private DefaultTableModel model = new DefaultTableModel(
            new String[] { "Tên giày", "Số lượng", "Đơn giá", "Thành tiền" }, 0);
    private JTable table = new JTable(model);

    private JComboBox<Shoe> cboShoe;
    private JTextField txtQuantity, txtTotal;
    private Invoice invoice;
    private int invoiceId = manager.getInvoices().size() + 1;

    public InvoiceForm() {
        setTitle("Tạo hóa đơn");
        setSize(600, 400);
        setLocationRelativeTo(null);

        invoice = new Invoice(invoiceId);

        JPanel top = new JPanel();
        cboShoe = new JComboBox<>();
        for (Shoe s : store.getShoes())
            cboShoe.addItem(s);
        txtQuantity = new JTextField(5);
        JButton btnAdd = new JButton("Thêm vào hóa đơn");
        top.add(new JLabel("Chọn giày:"));
        top.add(cboShoe);
        top.add(new JLabel("Số lượng:"));
        top.add(txtQuantity);
        top.add(btnAdd);

        JScrollPane scroll = new JScrollPane(table);

        JPanel bottom = new JPanel();
        txtTotal = new JTextField(10);
        txtTotal.setEditable(false);
        JButton btnSave = new JButton("Lưu & Xuất");
        bottom.add(new JLabel("Tổng tiền:"));
        bottom.add(txtTotal);
        bottom.add(btnSave);

        add(top, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> addItem());
        btnSave.addActionListener(e -> saveInvoice());
    }

    private void addItem() {
        try {
            Shoe s = (Shoe) cboShoe.getSelectedItem();
            int qty = Integer.parseInt(txtQuantity.getText());
            InvoiceItem item = new InvoiceItem(s, qty);
            invoice.addItem(item);
            model.addRow(new Object[] { s.getName(), qty, s.getPrice(), item.getSubtotal() });
            txtTotal.setText(String.valueOf(invoice.getTotal()));
            txtQuantity.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sai dữ liệu!");
        }
    }

    private void saveInvoice() {
        if (invoice.getItems().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hóa đơn trống!");
            return;
        }
        manager.addInvoice(invoice);
        JOptionPane.showMessageDialog(this, "Đã lưu hóa đơn!");
        dispose();
    }
}
