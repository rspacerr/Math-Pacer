import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JTextField textfield;
    private int x, y, count;
    private JLabel label;
    private JButton submit;
    private JLabel correct = new JLabel("");
    private JLabel streak = new JLabel("");

    public GUI() {
        frame = new JFrame();
        panel = new JPanel();
        textfield = new JTextField();
        x = (int)(Math.random() * 30 + 1);
        y = (int)(Math.random() * 30 + 1);
        label = new JLabel(x + " + " + y);
        submit = new JButton("Submit");

        label.setBounds(170, 20, 80, 25);
        panel.add(label);

        textfield.setBounds(105, 60, 165, 25);
        panel.setLayout(null);
        panel.add(textfield);

        submit.setBounds(150, 100, 80, 20);
        submit.addActionListener(this);
        panel.add(submit);
        
        correct.setBounds(150, 120, 150, 25);
        streak.setBounds(150, 140, 150, 25);
        streak.setText("Current streak: " + count);
        panel.add(correct);
        panel.add(streak);
        

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setTitle("Math Pacer");
        frame.add(panel);
        frame.setVisible(true);
    }

    public String getTextfield() {
        return textfield.getText();
    }

    public void generateNumbers() {
        x = (int)(Math.random() * 30 + 1);
        y = (int)(Math.random() * 30 + 1);
        label.setText(x + " + " + y);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Integer.parseInt(getTextfield()) == (x+y)) {
            correct.setText("Correct!");
            count++;
        }
        else {
            correct.setText("Incorrect! The correct answer was " + (x+y));
            count = 0;
        }
        textfield.setText("");
        generateNumbers();
        streak.setText("Current streak: " + count);
    }
}

