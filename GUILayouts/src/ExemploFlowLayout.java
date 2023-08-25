import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class ExemploFlowLayout {
    public ExemploFlowLayout() {
        //criar uma janela do tipo frame
        JFrame janela1 = new JFrame("Janela FlowLayout");
        //Chamei o Layout
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);  //Atribui o layout
        //criar alguns componentes
        janela1.add(new JLabel("Nº de botões"));
        JTextField campoTexto = new JTextField("Insira um Valor", 25);
        janela1.add(campoTexto);
        JButton enviar = new JButton("Enviar");
        janela1.add(enviar);
        enviar.addActionListener(null);         
        enviar.addActionListener(e ->{
            int valor = Integer.parseInt(campoTexto.getText());
            for (int i = 0; i < valor; i++) {
                janela1.add(new JButton(""+i+1));
            }
            janela1.pack();

        });

        //seta os elementos da Janela
        janela1.setDefaultCloseOperation(0);
        janela1.pack();
        janela1.setVisible(true);

        

    }
}
