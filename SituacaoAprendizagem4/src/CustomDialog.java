
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomDialog extends JDialog {
    public CustomDialog(JFrame parent, String message, int delay) {
        super(parent, "Confirmação de Exclusão", true);
        
        // Crie uma etiqueta com a mensagem
        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        // Crie um temporizador para fechar a janela após um atraso
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela de diálogo
            }
        });
        timer.setRepeats(false);
        timer.start();

        pack();
        setLocationRelativeTo(parent);
    }
}