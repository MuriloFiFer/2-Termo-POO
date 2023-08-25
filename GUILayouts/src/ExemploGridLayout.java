import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExemploGridLayout {
    public ExemploGridLayout() {
        JFrame janela1 = new JFrame("Exemplo GridLayout");
        JPanel painel1 = new JPanel();
        GridLayout grid = new GridLayout(2,2);
        painel1.setLayout(grid);
        //adicionar Jpanel ao JFrane
        janela1.getContentPane().add(painel1);
        //adicionar componentes
        painel1.add(new JButton("1"));
        painel1.add(new JButton("2"));
        painel1.add(new JButton("3"));
        painel1.add(new JButton("4"));
        
        //configurar janela1
        janela1.setBounds(500,500,500,500);
        janela1.setDefaultCloseOperation(2); //conf para fechar a janela e interromper o programa
        janela1.setVisible(true);


    }
}
