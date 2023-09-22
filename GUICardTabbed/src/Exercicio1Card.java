import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;


public class Exercicio1Card extends JFrame{

    
    //construtor
    public Exercicio1Card(){
        super("Exercicio 1");
         JPanel painel1 = new JPanel();//painel1 painel principal
         
         //elemento de seleção dos Cards JComboBoc
         
         JButton botao1 = new JButton("Trocar Card");
         painel1.add(botao1);
      

         //criar os cards
      
         CardLayout cl = new CardLayout();
         //criar os cards da pilha
         JPanel cards = new JPanel();
         JPanel card1 = new JPanel();
         JPanel card2 = new JPanel();
         JPanel card3 = new JPanel();
         
         card1.add(new JTextField("Card 1", 20));        
         cards.add(card1);
         painel1.add(cards);
         this.add(painel1);

         
         card2.add(new JTextField("Card 2", 20));
         cards.add(card2);
         painel1.add(cards);
         this.add(painel1);
         //adicionando cards a pilha(principal)

   
         card3.add(new JTextField("Card 3", 20));
         //adicionando cards a pilha(principal)
   
      
      
         //set do Frame
         this.setDefaultCloseOperation(2);
         this.setBounds(100,100,500,200);
         this.setVisible(true);
         //criar a ação para o Botãp
         botao1.addItemListener(e->{
             cl.show(cards, (String)e.getItem());
         });
 
         
 
     }      
 }
