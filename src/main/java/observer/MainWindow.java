package observer;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Person;
import strategy.CSVSaver;
import strategy.FileSaver;
import strategy.JSONSaver;
import strategy.XMLSaver;

public class MainWindow implements ActionListener {
    private JFrame jframe;
    private JTextField jtfName;
    private JTextField jtfAge;
    private JButton btnSave;
    private List<FileSaver> savers = new ArrayList<>();

    private FileSaver[] matrix = { new CSVSaver(), new XMLSaver(), new JSONSaver() };

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String name = jtfName.getText();
            int age = Integer.parseInt(jtfAge.getText());
            Person p = new Person(name, age);
            for (FileSaver fileSaver : savers) {
                fileSaver.save(p);
            }
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
        JPanel checkBoxes = new JPanel();
        for (FileSaver fileSaver : matrix) {
            JCheckBox cb = new JCheckBox(new AbstractAction(fileSaver.toString()) {
                FileSaver saver = fileSaver;

                @Override
                public void actionPerformed(ActionEvent e) {
                    JCheckBox jcb = (JCheckBox) e.getSource();
                    if (jcb.isSelected()) {
                        savers.add(saver);
                    } else {
                        savers.remove(saver);
                    }
                }
            });
            checkBoxes.add(cb);
        }
        c.add(checkBoxes);
        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
        c.add(btnSave);

        this.jframe.setSize(400, 150);
        this.jframe.setVisible(true);
        jtfName.requestFocus();
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
