import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora1 {
    public Calculadora1(){

           //Construir o Layout de uma Calculadora
        //JFrame é a janela principal
        JFrame janelaP = new JFrame("Layout Calculadora");
        janelaP.getContentPane().setBackground(Color.RED); 

    

        
        //criando o Border e mudando layout do JFrame para Border
         BorderLayout border = new BorderLayout();
         janelaP.setLayout(border);
         //criando 2 paineis (painelN-isual) (painelC-otoes)
         JPanel painelN = new JPanel();
         JPanel painelC = new JPanel();
         //criar painel SC para incluir 0,-,= nele
         JPanel painelSC = new JPanel();

      
         
         //setando posições dos paineis com Border.
         //painelN = Caixa de texto (NORTH)
        janelaP.getContentPane().add(painelN, BorderLayout.NORTH); 
        //painelC = Botões de numeros de 7 á 3 com /, *; +;
        janelaP.getContentPane().add(painelC, BorderLayout.CENTER); 
        //painelSC = Botões de numero 0, -, =, "Limpar(C)";                  
        janelaP.getContentPane().add(painelSC, BorderLayout.SOUTH);   

         
         //adicionado o textFiled no painelN  (Norte) caixa de texto)
         JTextField caixa1 = new JTextField(25);
            painelN.add(caixa1);
            painelN.setPreferredSize(new Dimension(25,30));
                
 
     
        //Set Layout do JPanel
        //set do painelC, setando numero de linhas e colunas
        GridLayout grid1 = new GridLayout(3,4); // 
        painelC.setLayout(grid1);
        String texBotoes[]={"7","8","9","/","4","5","6","*","1","2","3","+"};
       
        //set do Layout do painelSC(grid2 e grid3)
        //nessa etapa foi necessario dividir o painelSC em 2x, "Center" e "South".
        //1º grid do painelSC "grid2" contendo botão 0,-;
        GridLayout grid2 = new GridLayout(2,2); // 
        painelSC.setLayout(grid2);
        String textBotoes2[]={"0","-",};
        //2º Layout do painelSC "grid3" contendo botão =, Limpar(C);
         GridLayout grid3 = new GridLayout(2,1); // 
        painelSC.setLayout(grid3);
        String textBotoes3[]={"=","Limpar(c)"};


        
       

        
        for (int i = 0; i < texBotoes.length; i++) {
            //set de cor do botão textBotoes
            JButton botao = new JButton(texBotoes[i]);
            //set cor do botão
            botao.setBackground(Color.white); 
             //set de borda no botão, largura e cor
             botao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 110), 2));  
             // Alterando o tamanho do botão
            botao.setPreferredSize(new Dimension(80,80));
            painelC.add(botao);
        }

        for (int i = 0; i < textBotoes2.length; i++) {
            JButton botao2 = new JButton(textBotoes2[i]);
            botao2.setBackground(Color.white);
            //set de borda no botão, largura e cor
            botao2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 110), 2));  
            //set tamanho do botão
            botao2.setPreferredSize(new Dimension(80, 60));
            
                 painelSC.add(botao2);
            
        }

         for (int i = 0; i < textBotoes3.length; i++) {
              JButton botao3 = new JButton(textBotoes3[i]);
              //set cor do botão
            botao3.setBackground(Color.white);
             //set de borda no botão, largura e cor
              botao3.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 110), 2)); 
            //set tamanho do botão
            botao3.setPreferredSize(new Dimension(80,60));
            painelSC.add(botao3);
        }
     
     

          //set do Frame (janelaP)
          janelaP.setBounds(500,500,250,480);     

          janelaP.setDefaultCloseOperation(2); //conf para fechar a janela e interromper o programa
          janelaP.setVisible(true);
          


    }
    }
