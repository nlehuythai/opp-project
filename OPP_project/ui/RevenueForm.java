package ui;

import store.InvoiceManager;
import model.Invoice;
import model.InvoiceItem;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class RevenueForm extends JFrame {
    private InvoiceManager manager = new InvoiceManager();
    private JTextArea txtReport = new JTextArea();

    public RevenueForm() {
        setTitle("Báo cáo doanh thu");
        setSize(500, 400);
        setLocationRelativeTo(null);

        JButton btnLoad = new JButton("Tính & Xuất báo cáo");
        add(new JScrollPane(txtReport), BorderLayout.CENTER);
        add(btnLoad, BorderLayout.SOUTH);

        btnLoad.addActionListener(e -> generateReport());
    }

    private void generateReport() {
        try {
            double totalRevenue = 0;
            StringBuilder sb = new StringBuilder();
            sb.append("===== BÁO CÁO DOANH THU =====\n\n");
            for (Invoice inv : manager.getInvoices()) {
                sb.append("Invoice #").append(inv.getId()).append(" - ").append(inv.getDate()).append("\n");
                for (InvoiceItem item : inv.getItems()) {
                    sb.append(item.getShoe().getName())
                            .append(" x").append(item.getQuantity())
                            .append(" = ").append(item.getSubtotal()).append("\n");
                }
                sb.append("Tổng: ").append(inv.getTotal()).append("\n\n");
                totalRevenue += inv.getTotal();
            }
            sb.append("=== TỔNG DOANH THU: ").append(totalRevenue).append(" ===\n");
            txtReport.setText(sb.toString());

            // Xuất file report
            BufferedWriter bw = new BufferedWriter(new FileWriter("report/revenue_report.txt"));
            bw.write(sb.toString());
            bw.close();
            JOptionPane.showMessageDialog(this, "Đã xuất report/revenue_report.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
