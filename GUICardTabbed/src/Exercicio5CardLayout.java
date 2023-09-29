import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.*;


public class Exercicio5CardLayout extends JFrame {

    //contagem acertos e erros
    private int acertos = 0;
    private int erros = 0;
    private JLabel acertosLabel;
    private JLabel errosLabel;

    public Exercicio5CardLayout() {
        super("Exercicio 5 - HLC");

        JPanel mainPanel = new JPanel();
        CardLayout cl = new CardLayout();
        mainPanel.setLayout(cl);
        this.add(mainPanel);
       

        // Tela de Início
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Bem vindo ao jogo de Quiz (Verdadeiro ou Falso)"));
        JButton but1 = new JButton("Iniciar o jogo");
        card1.add(but1);
        mainPanel.add(card1, "Inicio");
        card1.setBackground(Color.LIGHT_GRAY); 
        but1.setBackground(Color.white); 

        // Tela 1ª Pergunta
        JPanel card2 = new JPanel();
        card2.add(new JLabel("O personagem Darth Vader é pai de Luke Skywalker em Star Wars."));
        JButton but2 = new JButton("Verdadeiro");
        JButton but3 = new JButton("Falso");
        JButton but4 = new JButton("Pular Pergunta");
        card2.add(but2);
        card2.add(but3);
        card2.add(but4);
        mainPanel.add(card2, "1ºPergunta");
        card2.setBackground(Color.LIGHT_GRAY); 
        but2.setBackground(Color.white); 
        but3.setBackground(Color.white); 
        but4.setBackground(Color.white); 

        // Tela 2ª Pergunta
        JPanel card3 = new JPanel();
        card3.add(new JLabel("O livro \"O Senhor dos Anéis\" foi escrito por J.K. Rowling.                      "));
        JButton but5 = new JButton("Verdadeiro");
        JButton but6 = new JButton("Falso");
        JButton but7 = new JButton("Pular Pergunta");
        card3.add(but5);
        card3.add(but6);
        card3.add(but7);
        mainPanel.add(card3, "2ºPergunta");
        card3.setBackground(Color.LIGHT_GRAY); 
        but5.setBackground(Color.white); 
        but6.setBackground(Color.white); 
        but7.setBackground(Color.white); 
        // Tela 3ª Pergunta
        JPanel card4 = new JPanel();
        card4.add(new JLabel("O personagem Mario, da franquia de videogames da Nintendo, é um encanador."));
        JButton but8 = new JButton("Verdadeiro");
        JButton but9 = new JButton("Falso");
        JButton but10 = new JButton("Resultado");
        card4.add(but8);
        card4.add(but9);
        card4.add(but10);
        mainPanel.add(card4, "3ºPergunta");
        card4.setBackground(Color.LIGHT_GRAY); 
        but8.setBackground(Color.white); 
        but9.setBackground(Color.white); 
        but10.setBackground(Color.white); 
        

        // Tela de Resultado
        JPanel card5 = new JPanel();
        card5.add(new JLabel("Resultado Final das perguntas"));
        acertosLabel = new JLabel("Acertos: 0");
        errosLabel = new JLabel("Erros: 0");
        card5.add(acertosLabel);
        card5.add(errosLabel);
        JButton but11 = new JButton("Voltar para o Início");
        card5.setBackground(Color.white); 
        but11.setBackground(Color.lightGray); 

        // Ação para o botão "Voltar para o Início"
        but11.addActionListener(e -> {
            cl.show(mainPanel, "Inicio");
            resetContagem();
        });

        card5.add(but11);
        mainPanel.add(card5, "Resultado");

        // Configuração do JFrame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setVisible(true);

        // Ações dos botões
        but1.addActionListener(e -> {
            cl.show(mainPanel, "1ºPergunta");   //Ao inves de usar "show"  poderia usar "next", previous, etc .. 
        });

        but2.addActionListener(e -> {
            cl.show(mainPanel, "2ºPergunta");
            verificarResposta(1, true);
        });

        but3.addActionListener(e -> {
            cl.show(mainPanel, "2ºPergunta");
            verificarResposta(1, false);
        });

        but4.addActionListener(e -> {
            cl.show(mainPanel, "2ºPergunta");
        });

        but5.addActionListener(e -> {
            cl.show(mainPanel, "3ºPergunta");
            verificarResposta(2, true);
        });

        but6.addActionListener(e -> {
            cl.show(mainPanel, "3ºPergunta");
            verificarResposta(2, false);
        });

        but7.addActionListener(e -> {
            cl.show(mainPanel, "3ºPergunta");
        });

        but8.addActionListener(e -> {
            cl.show(mainPanel, "Resultado");
            verificarResposta(3, true);
        });

        but9.addActionListener(e -> {
            cl.show(mainPanel, "Resultado");
            verificarResposta(3, false);
        });

        but10.addActionListener(e -> {
            cl.show(mainPanel, "Resultado");
        });
    }

    //---------

    //Zerador e Atualizador do resultado 
    private void resetContagem() {
        acertos = 0;
        erros = 0;
        atualizarResultado();
    }

    

    //verificador de condições
    private void verificarResposta(int numeroPergunta, boolean resposta) {
        boolean respostaCorreta = false;

        if (numeroPergunta == 1) {
            respostaCorreta = resposta == true; // Resposta correta para a 1ª pergunta
        } else if (numeroPergunta == 2) {
            respostaCorreta = resposta == false; // Resposta correta para a 2ª pergunta
        } else if (numeroPergunta == 3) {
            respostaCorreta = resposta == true; // Resposta correta para a 3ª pergunta
        }

        if (respostaCorreta) {
            acertos++;
        } else {
            erros++;
        }

        atualizarResultado();
    }

    //atualizador e indicador de resultados
    private void atualizarResultado() {
        acertosLabel.setText("Acertos: " + acertos);
        errosLabel.setText("Erros: " + erros);
    }

   
    }

