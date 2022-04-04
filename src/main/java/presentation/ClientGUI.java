package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ClientGUI extends JFrame {
    private JTextField addFirstNameText;
    private JTextField addLastNameText;
    private JTextField addAgeText;
    private JTextField addIDText;
    private JTextField editFirstNameText;
    private JTextField editLastNameText;
    private JTextField editAgeText;
    private JTextField editIDText;
    private JTextField deleteIDText;
    private JButton addB;
    private JButton editB;
    private JButton clientsB;
    private JButton deleteB;
    private JButton backB;
    public ClientGUI() {
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

        JLabel firstnE = new JLabel("First name:");
        firstnE.setForeground(new Color(0, 100, 0));
        firstnE.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        firstnE.setBounds(10, 76, 121, 61);
        panelAdd.add(firstnE);

        addFirstNameText = new JTextField();
        addFirstNameText.setBounds(131, 98, 121, 23);
        panelAdd.add(addFirstNameText);
        addFirstNameText.setColumns(10);

        JLabel lastNe = new JLabel("Last name:");
        lastNe.setForeground(new Color(0, 100, 0));
        lastNe.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        lastNe.setBounds(10, 107, 121, 61);
        panelAdd.add(lastNe);

        addLastNameText = new JTextField();
        addLastNameText.setColumns(10);
        addLastNameText.setBounds(131, 131, 121, 23);
        panelAdd.add(addLastNameText);

        JLabel ageE = new JLabel("Age:");
        ageE.setForeground(new Color(0, 100, 0));
        ageE.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        ageE.setBounds(10, 140, 121, 61);
        panelAdd.add(ageE);

        addAgeText = new JTextField();
        addAgeText.setColumns(10);
        addAgeText.setBounds(131, 164, 121, 23);
        panelAdd.add(addAgeText);

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

        JLabel titleE = new JLabel("CLIENT");
        titleE.setForeground(new Color(0, 100, 0));
        titleE.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 28));
        titleE.setBounds(394, 10, 203, 61);
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

        JLabel fn = new JLabel("First name:");
        fn.setForeground(new Color(0, 100, 0));
        fn.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        fn.setBounds(10, 76, 121, 61);
        panelEdit.add(fn);

        editFirstNameText = new JTextField();
        editFirstNameText.setColumns(10);
        editFirstNameText.setBounds(131, 98, 121, 23);
        panelEdit.add(editFirstNameText);

        JLabel ln = new JLabel("Last name:");
        ln.setForeground(new Color(0, 100, 0));
        ln.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        ln.setBounds(10, 107, 121, 61);
        panelEdit.add(ln);

        editLastNameText = new JTextField();
        editLastNameText.setColumns(10);
        editLastNameText.setBounds(131, 131, 121, 23);
        panelEdit.add(editLastNameText);

        JLabel a = new JLabel("Age:");
        a.setForeground(new Color(0, 100, 0));
        a.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        a.setBounds(10, 140, 121, 61);
        panelEdit.add(a);

        editAgeText = new JTextField();
        editAgeText.setColumns(10);
        editAgeText.setBounds(131, 164, 121, 23);
        panelEdit.add(editAgeText);

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

        clientsB = new JButton("Clients");
        clientsB.setForeground(new Color(0, 100, 0));
        clientsB.setFont(new Font("Tahoma", Font.BOLD, 15));
        clientsB.setBounds(661, 311, 144, 27);
        panel.add(clientsB);
    }

    public JButton getAddB() {
        return addB;
    }

    public JButton getBackB() {
        return backB;
    }

    public JButton getClientsB() {
        return clientsB;
    }

    public JButton getDeleteB() {
        return deleteB;
    }

    public JButton getEditB() {
        return editB;
    }

    public int getAddAgeText() {
        return Integer.parseInt(addAgeText.getText());
    }

    public String getAddFirstNameText() {
        return addFirstNameText.getText();
    }

    public int getAddIDText() {
        return Integer.parseInt(addIDText.getText());
    }

    public String getAddLastNameText() {
        return addLastNameText.getText();
    }

    public int getDeleteIDText() {
        return Integer.parseInt(deleteIDText.getText());
    }

    public String getEditAgeText() {
        return editAgeText.getText();
    }

    public String getEditFirstNameText() {
        return editFirstNameText.getText();
    }

    public String getEditIDText() {
        return editIDText.getText();
    }

    public String getEditLastNameText() {
        return editLastNameText.getText();
    }
}
