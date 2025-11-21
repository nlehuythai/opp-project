package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Shoe Store Management");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnShoe = new JButton("Quản lý giày");
        JButton btnInvoice = new JButton("Tạo hóa đơn");
        JButton btnRevenue = new JButton("Báo cáo doanh thu");

        add(btnShoe);
        add(btnInvoice);
        add(btnRevenue);

        btnShoe.addActionListener(e -> new ShoeForm().setVisible(true));
        btnInvoice.addActionListener(e -> new InvoiceForm().setVisible(true));
        btnRevenue.addActionListener(e -> new RevenueForm().setVisible(true));
    }

    public static void main(String[] args) {
        new MainMenu().setVisible(true);
    }
}
