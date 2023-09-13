## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


//
java import java.awt.GridLayout;
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


    //

    codigo atualizado

    import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora1 {
    public Calculadora1() {
        // Construir o Layout de uma Calculadora
        // JFrame é a janela principal
        JFrame janelaP = new JFrame("Layout Calculadora");
        // criando o Border e mudando o layout do JFrame para BorderLayout
        janelaP.setLayout(new BorderLayout());
        // criando 2 painéis (painelN-visual) (painelC-botoes)
        JPanel painelN = new JPanel();
        JPanel painelC = new JPanel(new GridLayout(5, 3)); // 5 linhas e 3 colunas
        // criar painel SC para incluir 0, -, = nele
        JPanel painelSC = new JPanel(new BorderLayout());

        // setando posições dos painéis com Border.
        janelaP.getContentPane().add(painelN, BorderLayout.NORTH);
        janelaP.getContentPane().add(painelC, BorderLayout.CENTER);
        janelaP.getContentPane().add(painelSC, BorderLayout.SOUTH);

        // adicionar o textField no painelN
        JTextField caixa1 = new JTextField(25);
        painelN.add(caixa1);

        // Set Layout do painelC
        String texBotoes[] = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "+", "0", "-" };

        for (int i = 0; i < texBotoes.length; i++) {
            JButton button = new JButton(texBotoes[i]);
            painelC.add(button);
        }

        // Adicionar um painel vazio para ocupar a primeira célula da última linha
        JPanel painelVazio = new JPanel();
        painelC.add(painelVazio);

        // Adicionar o botão "=" ao painelSC
        JButton botaoIgual = new JButton("=");
        botaoIgual.setFont(botaoIgual.getFont().deriveFont(24.0f)); // Aumentar o tamanho da fonte do "="
        painelSC.add(botaoIgual, BorderLayout.CENTER);

        // set do Frame (janelaP)
        janelaP.setBounds(500, 500, 500, 500);
        janelaP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaP.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculadora1();
    }
}

    