package ui;

import model.Shoe;
import store.ShoeStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ShoeForm extends JFrame {
    private ShoeStore store = new ShoeStore();
    private JTable table;
    private DefaultTableModel model;

    private JTextField txtId, txtName, txtType, txtBrand, txtSize, txtPrice;

    public ShoeForm() {
        setTitle("Quản lý giày");
        setSize(700, 400);
        setLocationRelativeTo(null);

        model = new DefaultTableModel(new String[] { "ID", "Tên", "Loại", "Hãng", "Size", "Giá" }, 0);
        table = new JTable(model);
        loadTable();

        JScrollPane scroll = new JScrollPane(table);

        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));
        txtId = new JTextField();
        txtName = new JTextField();
        txtType = new JTextField();
        txtBrand = new JTextField();
        txtSize = new JTextField();
        txtPrice = new JTextField();
        form.add(new JLabel("ID"));
        form.add(txtId);
        form.add(new JLabel("Tên"));
        form.add(txtName);
        form.add(new JLabel("Loại"));
        form.add(txtType);
        form.add(new JLabel("Hãng"));
        form.add(txtBrand);
        form.add(new JLabel("Size"));
        form.add(txtSize);
        form.add(new JLabel("Giá"));
        form.add(txtPrice);

        JPanel buttons = new JPanel();
        JButton btnAdd = new JButton("Thêm"), btnEdit = new JButton("Sửa"), btnDelete = new JButton("Xóa");
        buttons.add(btnAdd);
        buttons.add(btnEdit);
        buttons.add(btnDelete);

        add(scroll, BorderLayout.CENTER);
        add(form, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> addShoe());
        btnEdit.addActionListener(e -> editShoe());
        btnDelete.addActionListener(e -> deleteShoe());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                if (r >= 0) {
                    txtId.setText(model.getValueAt(r, 0).toString());
                    txtName.setText(model.getValueAt(r, 1).toString());
                    txtType.setText(model.getValueAt(r, 2).toString());
                    txtBrand.setText(model.getValueAt(r, 3).toString());
                    txtSize.setText(model.getValueAt(r, 4).toString());
                    txtPrice.setText(model.getValueAt(r, 5).toString());
                }
            }
        });
    }

    private void loadTable() {
        model.setRowCount(0);
        for (Shoe s : store.getShoes()) {
            model.addRow(new Object[] { s.getId(), s.getName(), s.getType(), s.getBrand(), s.getSize(), s.getPrice() });
        }
    }

    private void addShoe() {
        try {
            Shoe s = new Shoe(txtId.getText(), txtName.getText(), txtType.getText(),
                    txtBrand.getText(), Integer.parseInt(txtSize.getText()),
                    Double.parseDouble(txtPrice.getText()));
            store.addShoe(s);
            loadTable();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sai dữ liệu!");
        }
    }

    private void editShoe() {
        int r = table.getSelectedRow();
        if (r >= 0) {
            Shoe s = store.getShoes().get(r);
            s.setName(txtName.getText());
            s.setType(txtType.getText());
            s.setBrand(txtBrand.getText());
            s.setSize(Integer.parseInt(txtSize.getText()));
            s.setPrice(Double.parseDouble(txtPrice.getText()));
            store.save();
            loadTable();
            clearForm();
        }
    }

    private void deleteShoe() {
        int r = table.getSelectedRow();
        if (r >= 0) {
            Shoe s = store.getShoes().get(r);
            store.removeShoe(s);
            loadTable();
            clearForm();
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtType.setText("");
        txtBrand.setText("");
        txtSize.setText("");
        txtPrice.setText("");
    }
}
