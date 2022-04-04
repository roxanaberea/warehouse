package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainGUI extends JFrame {
    private JButton clientB;
    private JButton orderB;
    private JButton productB;
    public MainGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 422, 280);
        JPanel panel = new JPanel();
        panel.setForeground(new Color(0, 0, 0));
        panel.setBackground(new Color(102, 205, 170));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel et = new JLabel("Welcome!");
        et.setForeground(new Color(0, 100, 0));
        et.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 28));
        et.setBounds(132, 10, 203, 61);
        panel.add(et);

        clientB = new JButton("CLIENT");
        clientB.setForeground(new Color(0, 100, 0));
        clientB.setFont(new Font("Tahoma", Font.BOLD, 15));
        clientB.setBounds(54, 104, 114, 26);
        panel.add(clientB);

        orderB = new JButton("ORDER");
        orderB.setForeground(new Color(0, 100, 0));
        orderB.setFont(new Font("Tahoma", Font.BOLD, 15));
        orderB.setBounds(211, 104, 114, 26);
        panel.add(orderB);

        productB = new JButton("PRODUCT");
        productB.setForeground(new Color(0, 100, 0));
        productB.setFont(new Font("Tahoma", Font.BOLD, 15));
        productB.setBounds(133, 145, 114, 26);
        panel.add(productB);
    }

    public JButton getClientB() {
        return clientB;
    }

    public JButton getOrderB() {
        return orderB;
    }

    public JButton getProductB() {
        return productB;
    }
}

