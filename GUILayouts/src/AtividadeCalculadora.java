import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AtividadeCalculadora {
    public AtividadeCalculadora() {
        //Construir o Layout de uma Calculadora
        //JFrame é a janela principal
        JFrame janelaP = new JFrame("Layout Calculadora");
        //criando o Border e mudando layout do JFrame para Border
         BorderLayout border = new BorderLayout();
         janelaP.setLayout(border);
         //criando 2 paineis (painelV-isual) (painelB-otoes)
         JPanel painelV = new JPanel();
         JPanel painelB = new JPanel();
         //setando posições dos paineis com Border.
         janelaP.getContentPane().add(painelB, BorderLayout.CENTER);
         janelaP.getContentPane().add(painelV, BorderLayout.NORTH);
         //adicionar o textFiled no PainelV
         JTextField caixa1 = new JTextField(25);
         painelV.add(caixa1);


   
     
        //JPanel é a janela interna dentro do JFrame
         JPanel painelA = new JPanel();
           painelA.add(new JLabel("Nº de botões"));
     
        janelaP.getContentPane().add(painelB);
        //Set Layout do JPanel
        GridLayout grid = new GridLayout(4,4); // criando grid e setando para 4x4 
        painelB.setLayout(grid);
        //Vetor com os textos dos Botões
        String texBotoes[]={"C","9","8","7","/","6","5","4","*","3","2","1","-","+","0","="};
        for (int i = 0; i < texBotoes.length; i++) {
            painelB.add(new JButton(texBotoes[i]));
        }
       

          //set do Frame (janelaP)
          janelaP.setBounds(500,500,500,500);
          janelaP.setDefaultCloseOperation(2); //conf para fechar a janela e interromper o programa
          janelaP.setVisible(true);


    }
}