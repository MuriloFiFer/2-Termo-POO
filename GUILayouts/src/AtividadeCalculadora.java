import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtividadeCalculadora extends JFrame {
    private JTextField textField;
    private double primeiroNumero = 0;
    private String operacao = "";
    private boolean novoNumero = true;

    public void CalculadoraComClear() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 4));

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);

        painel.add(textField);

        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"  // Botão Clear
        };

        for (String btnText : botoes) {
            JButton botao = new JButton(btnText);
            botao.setFont(new Font("Arial", Font.PLAIN, 18));
            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    botaoClicado(btnText);
                }
            });
            painel.add(botao);
        }

        add(painel);
        setVisible(true);
    }

    private void botaoClicado(String texto) {
        if (novoNumero) {
            textField.setText("");
            novoNumero = false;
        }

        if (texto.matches("[0-9.]")) {
            textField.setText(textField.getText() + texto);
        } else if (texto.matches("[-+*/]")) {
            calcular();
            operacao = texto;
        } else if (texto.equals("=")) {
            calcular();
            operacao = "";
        } else if (texto.equals("C")) {
            textField.setText("");
            primeiroNumero = 0;
            operacao = "";
        }
    }

    private void calcular() {
        double segundoNumero = Double.parseDouble(textField.getText());

        switch (operacao) {
            case "+":
                primeiroNumero += segundoNumero;
                break;
            case "-":
                primeiroNumero -= segundoNumero;
                break;
            case "*":
                primeiroNumero *= segundoNumero;
                break;
            case "/":
                if (segundoNumero != 0) {
                    primeiroNumero /= segundoNumero;
                } else {
                    textField.setText("Erro");
                    return;
                }
                break;
        }

        textField.setText(Double.toString(primeiroNumero));
        novoNumero = true;

    
    }

  
}
