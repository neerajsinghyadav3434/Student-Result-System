import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class markSheet extends Frame implements ActionListener {
    Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    Button b1, b2;
    TextField t1, t2, t3, t4, t5, t6, t7;
    Checkbox cb1, cb2;

    public markSheet() {
        // Set frame title and background color
        setTitle("Student Result System");
        setBackground(new Color(240, 248, 255));  // Light background color

        // Custom Font for Labels
        Font labelFont = new Font("SansSerif", Font.BOLD, 14);

        // Initializing Labels
        l1 = new Label("Roll No:");
        l1.setFont(labelFont);
        l2 = new Label("Name:");
        l2.setFont(labelFont);
        l3 = new Label("Hindi Marks: ");
        l3.setFont(labelFont);
        l4 = new Label("English Marks: ");
        l4.setFont(labelFont);
        l5 = new Label("Science Marks: ");
        l5.setFont(labelFont);
        l6 = new Label("Total:");
        l6.setFont(labelFont);
        l7 = new Label("Percentage:");
        l7.setFont(labelFont);
        l8 = new Label("");
        l9 = new Label("");
        l10 = new Label("");
        l11 = new Label("");

        // Label font color
        l8.setForeground(new Color(0, 128, 128));
        l9.setForeground(new Color(0, 128, 128));
        l10.setForeground(new Color(0, 128, 128));
        l11.setForeground(new Color(0, 128, 128));


        CheckboxGroup cbg1 = new CheckboxGroup();
        cb1 = new Checkbox("Male", cbg1, false);
        cb2 = new Checkbox("Female", cbg1, false);

        // Font for Buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 12);

        b1 = new Button("Submit");
        b1.setFont(buttonFont);
        b1.setBackground(new Color(50, 205, 50));
        b1.setForeground(Color.WHITE);  // White text

        b2 = new Button("Clear");
        b2.setFont(buttonFont);
        b2.setBackground(new Color(255, 69, 0));  // Orange red background
        b2.setForeground(Color.WHITE);

        t1 = new TextField(10);
        t2 = new TextField(10);
        t3 = new TextField(10);
        t4 = new TextField(10);
        t5 = new TextField(10);
        t6 = new TextField(10);
        t6.setEditable(false);
        t7 = new TextField(10);
        t7.setEditable(false);


        t1.setBackground(new Color(255, 255, 224));
        t2.setBackground(new Color(255, 255, 224));
        t3.setBackground(new Color(255, 255, 224));
        t4.setBackground(new Color(255, 255, 224));
        t5.setBackground(new Color(255, 255, 224));
        t6.setBackground(new Color(224, 255, 255));
        t7.setBackground(new Color(224, 255, 255));


        setLayout(new GridLayout(12, 2, 10, 10));  // 10 px spacing between components


        add(l1); add(t1);
        add(l2); add(t2);
        add(cb1); add(cb2);
        add(l3); add(t3);
        add(l4); add(t4);
        add(l5); add(t5);
        add(l6); add(t6);
        add(l7); add(t7);
        add(b1); add(b2);
        add(l8); add(l9);
        add(l10); add(l11);


        b1.addActionListener(this);
        b2.addActionListener(this);


        setSize(400, 500);
        setVisible(true);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new markSheet();
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                // Parsing and calculating total and percentage
                int Hindi = Integer.parseInt(t3.getText());
                int English = Integer.parseInt(t4.getText());
                int Science = Integer.parseInt(t5.getText());
                int sum = Hindi + English + Science;
                float per = (float) sum / 3; // Correct float division


                t6.setText(String.valueOf(sum));
                t7.setText(String.format("%.2f", per));


                String data = "Roll No: " + t1.getText();
                l8.setText(data);
                String data1 = "Name: " + t2.getText();
                l9.setText(data1);
                String data2 = "Hindi : " + t3.getText() + " English : " + t4.getText() + " Science: " + t5.getText();
                l10.setText(data2);
                String data3 = "Total: " + t6.getText() + " Percentage: " + t7.getText();
                l11.setText(data3);
            } catch (NumberFormatException ex) {
                l8.setText("Invalid Input");
            }
        } else {

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            cb1.setState(false);
            cb2.setState(false);
            l8.setText("");
            l9.setText("");
            l10.setText("");
            l11.setText("");
        }
    }
}
