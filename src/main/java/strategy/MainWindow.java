package strategy;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Person;

public class MainWindow implements ActionListener {
    private JFrame jframe;
    private JComboBox<FileSaver> jcbSaver;
    private JTextField jtfName;
    private JTextField jtfAge;
    private JButton btnSave;

    private FileSaver[] matrix = { new CSVSaver(), new XMLSaver(), new JSONSaver() };

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String name = jtfName.getText();
            int age = Integer.parseInt(jtfAge.getText());
            Person p = new Person(name, age);
            FileSaver converter = (FileSaver) jcbSaver.getSelectedItem();
            converter.save(p);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public MainWindow() {
        this.jframe = new JFrame("File Saver");
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = this.jframe.getContentPane();
        GridLayout layout = new GridLayout(3, 2, 10, 10);
        c.setLayout(layout);
        c.add(new JLabel("Name:"));
        jtfName = new JTextField("Fulano");
        c.add(jtfName);
        c.add(new JLabel("Age:"));
        jtfAge = new JTextField("23");
        c.add(jtfAge);
        jcbSaver = new JComboBox<>(matrix);
        c.add(jcbSaver);
        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
        c.add(btnSave);

        this.jframe.setSize(300, 120);
        this.jframe.setVisible(true);
        jtfName.requestFocus();
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}