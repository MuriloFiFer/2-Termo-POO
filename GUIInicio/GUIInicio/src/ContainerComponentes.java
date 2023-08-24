
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContainerComponentes extends JFrame{
    public ContainerComponentes(){
        super("Exemplo Janela");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200,200,400,400); //tamanho da janela
       //determinando o layout da janela
       // FlowLayout flow = new FlowLayout();
        // this.setLayout(flow);
        //Utilizando um novo Container
       // --  FlowLayout flow = new FlowLayout(); 
       // -- this.setLayout(flow); //set do layout
       JPanel painel = new JPanel();//por padrão é um FlowLayout
        this.getContentPane().add(painel);
        for (int i = 0; i < 6; i++) { //contagem para criar 6 botões
            painel.add(new JButton("Number "+i));
           
            // this.add(new JButton("number " +i)); //adicionando botão
        }
        this.setVisible(true);  //deixando a janela visivel
    }
    
}
