import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaxCalculatorGUI extends JFrame {
    private JTextField incomeField;
    private JLabel taxAmountLabel;
    private Interest interest = new Interest();

    public TaxCalculatorGUI() {
        setTitle("Tax Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2));

        JLabel incomeLabel = new JLabel("Income (ZAR):");
        incomeField = new JTextField();
        JLabel taxRateLabel = new JLabel("Tax Rate (%):");
        JLabel taxRateValueLabel = new JLabel(" "); // South African tax rate example
        JLabel taxAmountTitleLabel = new JLabel("Tax Amount:        R");
        taxAmountLabel = new JLabel();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());

        mainPanel.add(incomeLabel);
        mainPanel.add(incomeField);
        mainPanel.add(taxRateLabel);
        mainPanel.add(taxRateValueLabel);
        mainPanel.add(taxAmountTitleLabel);
        mainPanel.add(taxAmountLabel);

        add(mainPanel, BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double income = Double.parseDouble(incomeField.getText());
            double taxAmount = calculateTax(income, interest.setInterest(income));
            // double taxRate = interest.setInterest(taxAmount);
            taxAmountLabel.setText(Double.toString(taxAmount));
        }
    }

    private double calculateTax(double income, double taxRate) {
//        System.out.println(taxRate);
        return (income + taxRate);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaxCalculatorGUI taxCalculatorGUI = new TaxCalculatorGUI();
            taxCalculatorGUI.setVisible(true);
        });
    }
}