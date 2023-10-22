import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGameGUI {
    private int numberToGuess;
    private int attempts;
    private JFrame frame;
    private JTextField textField;
    private JLabel resultLabel;

    public NumberGuessingGameGUI() {
        numberToGuess = new Random().nextInt(100) + 1;
        attempts = 0;

        frame = new JFrame("Number Guessing Game");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Guess the number (1-100):");
        textField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        resultLabel = new JLabel("");

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(guessButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(textField.getText());
            attempts++;

            if (userGuess < numberToGuess) {
                resultLabel.setText("Higher! Try again.");
            } else if (userGuess > numberToGuess) {
                resultLabel.setText("Lower! Try again.");
            } else {
                resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
                textField.setEnabled(false);
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberGuessingGameGUI();
            }
        });
    }
}

