package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ShowCGUI extends JFrame {

    private JButton back;

    public ShowCGUI(JTable dadada){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 450);
        JPanel panel = new JPanel();
        panel.setForeground(new Color(0, 0, 0));
        panel.setBackground(new Color(102, 205, 170));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 460, 350);
        panel.add(scrollPane);

        back = new JButton("Back");
        back.setForeground(new Color(0, 100, 0));
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBounds(350, 370, 120, 25);
        panel.add(back);


        scrollPane.setViewportView(dadada);
    }

    public JButton getBack()
    {
        return this.back;
    }
}

