package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProductGUI extends JFrame {
    private JTextField addNameText;
    private JTextField addPriceText;
    private JTextField addQuantityText;
    private JTextField addIDText;
    private JTextField editNameText;
    private JTextField editPriceText;
    private JTextField editQuantityText;
    private JTextField editIDText;
    private JTextField deleteIDText;
    private JButton addB;
    private JButton editB;
    private JButton productsB;
    private JButton deleteB;
    private JButton backB;
    public ProductGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 918, 469);
        JPanel panel = new JPanel();
        panel.setForeground(new Color(0, 0, 0));
        panel.setBackground(new Color(102, 205, 170));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        backB = new JButton("Back");
        backB.setForeground(new Color(0, 100, 0));
        backB.setFont(new Font("Tahoma", Font.BOLD, 15));
        backB.setBounds(10, 388, 114, 26);
        panel.add(backB);

        JPanel panelAdd = new JPanel();
        panelAdd.setBackground(new Color(230, 230, 250));
        panelAdd.setBounds(30, 94, 262, 253);
        panel.add(panelAdd);
        panelAdd.setLayout(null);

        JLabel addE = new JLabel("ADD");
        addE.setBounds(93, 0, 203, 61);
        panelAdd.add(addE);
        addE.setForeground(new Color(0, 100, 0));
        addE.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 23));

        JLabel firstnE = new JLabel("Name:");
        firstnE.setForeground(new Color(0, 100, 0));
        firstnE.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        firstnE.setBounds(10, 76, 121, 61);
        panelAdd.add(firstnE);

        addNameText = new JTextField();
        addNameText.setBounds(131, 98, 121, 23);
        panelAdd.add(addNameText);
        addNameText.setColumns(10);

        JLabel lastNe = new JLabel("Price:");
        lastNe.setForeground(new Color(0, 100, 0));
        lastNe.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        lastNe.setBounds(10, 107, 121, 61);
        panelAdd.add(lastNe);

        addPriceText = new JTextField();
        addPriceText.setColumns(10);
        addPriceText.setBounds(131, 131, 121, 23);
        panelAdd.add(addPriceText);

        JLabel ageE = new JLabel("Quantity:");
        ageE.setForeground(new Color(0, 100, 0));
        ageE.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        ageE.setBounds(10, 140, 121, 61);
        panelAdd.add(ageE);

        addQuantityText = new JTextField();
        addQuantityText.setColumns(10);
        addQuantityText.setBounds(131, 164, 121, 23);
        panelAdd.add(addQuantityText);

        addB = new JButton("Add");
        addB.setForeground(new Color(0, 100, 0));
        addB.setFont(new Font("Tahoma", Font.BOLD, 15));
        addB.setBounds(70, 211, 114, 26);
        panelAdd.add(addB);

        JLabel lblId = new JLabel("ID:");
        lblId.setForeground(new Color(0, 100, 0));
        lblId.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        lblId.setBounds(10, 47, 121, 61);
        panelAdd.add(lblId);

        addIDText = new JTextField();
        addIDText.setColumns(10);
        addIDText.setBounds(131, 71, 121, 23);
        panelAdd.add(addIDText);

        JLabel titleE = new JLabel("PRODUCT");
        titleE.setForeground(new Color(0, 100, 0));
        titleE.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 28));
        titleE.setBounds(358, 10, 203, 61);
        panel.add(titleE);

        JPanel panelEdit = new JPanel();
        panelEdit.setLayout(null);
        panelEdit.setBackground(new Color(230, 230, 250));
        panelEdit.setBounds(321, 94, 262, 253);
        panel.add(panelEdit);

        JLabel ed = new JLabel("EDIT");
        ed.setForeground(new Color(0, 100, 0));
        ed.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 23));
        ed.setBounds(93, 0, 203, 61);
        panelEdit.add(ed);

        JLabel fn = new JLabel("Name:");
        fn.setForeground(new Color(0, 100, 0));
        fn.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        fn.setBounds(10, 76, 121, 61);
        panelEdit.add(fn);

        editNameText = new JTextField();
        editNameText.setColumns(10);
        editNameText.setBounds(131, 98, 121, 23);
        panelEdit.add(editNameText);

        JLabel ln = new JLabel("Price:");
        ln.setForeground(new Color(0, 100, 0));
        ln.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        ln.setBounds(10, 107, 121, 61);
        panelEdit.add(ln);

        editPriceText = new JTextField();
        editPriceText.setColumns(10);
        editPriceText.setBounds(131, 131, 121, 23);
        panelEdit.add(editPriceText);

        JLabel a = new JLabel("Quantity");
        a.setForeground(new Color(0, 100, 0));
        a.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        a.setBounds(10, 140, 121, 61);
        panelEdit.add(a);

        editQuantityText = new JTextField();
        editQuantityText.setColumns(10);
        editQuantityText.setBounds(131, 164, 121, 23);
        panelEdit.add(editQuantityText);

        editB = new JButton("Edit");
        editB.setForeground(new Color(0, 100, 0));
        editB.setFont(new Font("Tahoma", Font.BOLD, 15));
        editB.setBounds(70, 211, 114, 26);
        panelEdit.add(editB);

        JLabel i = new JLabel("ID:");
        i.setForeground(new Color(0, 100, 0));
        i.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        i.setBounds(10, 47, 121, 61);
        panelEdit.add(i);

        editIDText = new JTextField();
        editIDText.setColumns(10);
        editIDText.setBounds(131, 71, 121, 23);
        panelEdit.add(editIDText);

        JPanel panelDelete = new JPanel();
        panelDelete.setLayout(null);
        panelDelete.setBackground(new Color(230, 230, 250));
        panelDelete.setBounds(608, 94, 262, 196);
        panel.add(panelDelete);

        JLabel d = new JLabel("DELETE");
        d.setForeground(new Color(0, 100, 0));
        d.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 23));
        d.setBounds(78, 0, 203, 61);
        panelDelete.add(d);

        deleteB = new JButton("Delete");
        deleteB.setForeground(new Color(0, 100, 0));
        deleteB.setFont(new Font("Tahoma", Font.BOLD, 15));
        deleteB.setBounds(72, 142, 114, 26);
        panelDelete.add(deleteB);

        JLabel id = new JLabel("ID:");
        id.setForeground(new Color(0, 100, 0));
        id.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        id.setBounds(54, 50, 121, 61);
        panelDelete.add(id);

        deleteIDText = new JTextField();
        deleteIDText.setColumns(10);
        deleteIDText.setBounds(92, 72, 114, 23);
        panelDelete.add(deleteIDText);

        productsB = new JButton("Products");
        productsB.setForeground(new Color(0, 100, 0));
        productsB.setFont(new Font("Tahoma", Font.BOLD, 15));
        productsB.setBounds(661, 311, 144, 27);
        panel.add(productsB);
    }

    public JButton getAddB() {
        return addB;
    }

    public JButton getBackB() {
        return backB;
    }

    public JButton getDeleteB() {
        return deleteB;
    }

    public JButton getEditB() {
        return editB;
    }

    public JButton getProductsB() {
        return productsB;
    }

    public int getAddIDText() {
        return Integer.parseInt(addIDText.getText());
    }

    public String getAddNameText() {
        return addNameText.getText();
    }

    public int getAddPriceText() {
        return Integer.parseInt(addPriceText.getText());
    }

    public int getAddQuantityText() {
        return Integer.parseInt(addQuantityText.getText());
    }

    public int getDeleteIDText() {
        return Integer.parseInt(deleteIDText.getText());
    }

    public int getEditIDText() {
        return Integer.parseInt(editIDText.getText());
    }

    public String getEditNameText() {
        return editNameText.getText();
    }

    public String getEditPriceText() {
        return editPriceText.getText();
    }

    public String getEditQuantityText() {
        return editQuantityText.getText();
    }
}

