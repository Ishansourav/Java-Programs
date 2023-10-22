import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel weightLabel = new JLabel("Weight (kg):");
        JTextField weightTextField = new JTextField(10);
        JLabel heightLabel = new JLabel("Height (m):");
        JTextField heightTextField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("BMI: ");

        frame.add(weightLabel);
        frame.add(weightTextField);
        frame.add(heightLabel);
        frame.add(heightTextField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double weight = Double.parseDouble(weightTextField.getText());
                double height = Double.parseDouble(heightTextField.getText());
                double bmi = calculateBMI(weight, height);
                resultLabel.setText("BMI: " + bmi);
            }
        });

        frame.setVisible(true);
    }

    private static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
}

