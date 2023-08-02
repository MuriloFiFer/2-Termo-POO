package Exception;



import javax.swing.JOptionPane;
import java.util.Scanner;
/**
* Classe utilizada para demonstrar o uso da palavra chave throw,
* utilizada quando queremos lançar uma exceção.
*/
public class ExemploTryCatch {
    

    public static void main(String[] args) {
        boolean rodando = true;
            while (rodando) {
            try {
                int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro"));
                int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro Nº Inteiro"));
                JOptionPane.showMessageDialog(null, "O resultado é "
                        + (numero1 + numero2));
                rodando = false;
            } catch (NumberFormatException erro1) {
                JOptionPane.showMessageDialog(null, "Erro - Valor digitado não é um inteiro"
                                                                    +"\nDigite novamente");
            } catch (Exception erro2) {
                JOptionPane.showMessageDialog(null, "Aconteceu um erro"
                                                                    +"\nDigite novamente");
            }
        }
    }
}


