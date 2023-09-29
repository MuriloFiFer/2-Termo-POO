import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

//cardLayout mostra apenas o primeiro card, podendo trocar para outros cards (caixa de cartas Super Trunfo/baralho)
public class Exercicio3CardLayout extends JFrame {
    public Exercicio3CardLayout() {
        super("Exercicio 3 - HLC");
        //Criar um Painel Principal -> CardLayout
        JPanel mainPanel = new JPanel();
        CardLayout cl = new CardLayout();
        mainPanel.setLayout(cl);
        //add painel principal ao frame
        this.add(mainPanel);
        //criar os cards da aplicação
        //card1- tela de inicio
         JPanel card1 = new JPanel();
        card1.add(new JLabel("Tela Inicial - Seja Bem Vindo"));
        JButton but1 = new JButton("Ir para Login");
        JButton but2 = new JButton("Ir para Cadastro");
        card1.add(but1);
        card1.add(but2);
        mainPanel.add(card1,"Inicio");
          //card2- tela de Login
         JPanel card2 = new JPanel();
        card2.add(new JLabel("Tela Login - Faça o seu Login"));
        JButton but3 = new JButton("Ir para Início");
        JButton but4 = new JButton("Ir para Cadastro");
        card2.add(but3);
        card2.add(but4);
        mainPanel.add(card2,"Login");
        //card3- tela de Cadastro
         JPanel card3 = new JPanel();
        card3.add(new JLabel("Tela Cadastro- Faça o seu Cadastro"));
        JButton but5 = new JButton("Ir para Início");
        JButton but6 = new JButton("Ir para Login");
        card3.add(but5);
        card3.add(but6);
        mainPanel.add(card3,"Cadastro");
        //set do Frame
        this.setDefaultCloseOperation(2);//Definindo a função do x do Frame (2) fecha janela e encerra o programa;
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);
        //criar as ações para os botões
        but1.addActionListener(e->{
            cl.show(mainPanel,"Login");
        });
        but2.addActionListener(e->{
            cl.show(mainPanel,"Cadastro");
        });
        but3.addActionListener(e->{
            cl.show(mainPanel,"Inicio");
        });
        but4.addActionListener(e->{
            cl.show(mainPanel,"Cadastro");
        });
        but5.addActionListener(e->{
            cl.show(mainPanel,"Inicio");
        });
        but6.addActionListener(e->{
            cl.show(mainPanel,"Login");
        });
              
    }
}
