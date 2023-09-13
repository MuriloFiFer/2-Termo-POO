import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora1 {
    public Calculadora1(){

           //Construir o Layout de uma Calculadora
        //JFrame é a janela principal
        JFrame janelaP = new JFrame("Layout Calculadora");
        //criando o Border e mudando layout do JFrame para Border
         BorderLayout border = new BorderLayout();
         janelaP.setLayout(border);
         //criando 2 paineis (painelN-isual) (painelC-otoes)
         JPanel painelN = new JPanel();
         JPanel painelC = new JPanel();
         //criar painel SC para incluir 0,-,= nele
         JPanel painelSC = new JPanel();

         JPanel painelS = new JPanel();
         JPanel painelS2 = new JPanel();
         
         //setando posições dos paineis com Border.
        janelaP.getContentPane().add(painelN, BorderLayout.NORTH); 
        janelaP.getContentPane().add(painelC, BorderLayout.CENTER);                   
        janelaP.getContentPane().add(painelSC, BorderLayout.SOUTH);
    

         
         //adicionar o textFiled no painelN
         JTextField caixa1 = new JTextField(25);
         painelN.add(caixa1);


   
     
        //JPanel é a janela interna dentro do JFrame
                  
     
    
      
      
        //Set Layout do JPanel
        GridLayout grid = new GridLayout(3,4); // 
        painelC.setLayout(grid);
        String texBotoes[]={"7","8","9","/","4","5","6","*","1","2","3","+"};
       
        GridLayout grid2 = new GridLayout(2,2); // 
        painelSC.setLayout(grid2);
        String textBotoes2[]={"0","-",};
         GridLayout grid3 = new GridLayout(2,2); // 
        painelSC.setLayout(grid3);
        String textBotoes3[]={"="};


        
       

        
        for (int i = 0; i < texBotoes.length; i++) {
            painelC.add(new JButton(texBotoes[i]));
        }
        for (int i = 0; i < textBotoes2.length; i++) {
            painelSC.add(new JButton(textBotoes2[i]));
        }

         for (int i = 0; i < textBotoes3.length; i++) {
            painelSC.add(new JButton(textBotoes3[i]));
        }
     
     

          //set do Frame (janelaP)
          janelaP.setBounds(500,500,500,500);
          janelaP.setDefaultCloseOperation(2); //conf para fechar a janela e interromper o programa
          janelaP.setVisible(true);
          


    }
    }
