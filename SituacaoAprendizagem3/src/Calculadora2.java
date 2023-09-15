import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora2 {
    public Calculadora2() {
        // Criar uma janela do tipo frame
        JFrame janela1 = new JFrame("Calculadora Científica");
        janela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configuração para fechar a janela
        janela1.setSize(240, 250); // Define o tamanho da janela
        janela1.setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout

        JTextField display = new JTextField(20); // Cria um campo de texto para exibir a entrada/saída
        janela1.add(display); // Adiciona o campo de texto à janela

        // Array dos botões
        String[] buttonLabels = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "sin", "cos", "tan"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label); //Criando o botão
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = display.getText(); // Obtém o texto atual no campo de texto
                    String buttonText = ((JButton) e.getSource()).getText(); // Obtém o texto do botão clicado
                    if (buttonText.equals("=")) {
                        try {
                            String result = evaluateExpression(currentText); // Avalia a expressão
                            display.setText(result); // Exibe o resultado no campo de texto
                        } catch (Exception ex) {
                            display.setText("Erro"); // Exibe "Erro" em caso de erro na avaliação
                        }
                    } else if (buttonText.equals("C")) {
                        display.setText(""); // Limpa o campo de texto quando o botão "C" é clicado
                    } else {
                        display.setText(currentText + buttonText); // Adiciona o texto do botão ao campo de texto
                    }
                }
            });
            janela1.add(button); // Adicionndoa o botão à janela
        }

        janela1.setVisible(true); // deixando a janela visivel
    }
}


    

    
