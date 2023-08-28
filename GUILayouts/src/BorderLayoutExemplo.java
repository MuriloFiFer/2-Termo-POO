import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JFrame;



public class BorderLayoutExemplo {
    public BorderLayoutExemplo(){


        super();
        JFrame janelaP = new JFrame("Janela Principal");
        //mudando o Layout oara BroderLayout do JFrane
        BorderLayout border = new BorderLayout();
        janelaP.setLayout(border);
        janelaP.add(new JButton("North"),BorderLayout.NORTH);
        janelaP.add(new JButton("South"),BorderLayout.SOUTH);
        janelaP.add(new JButton("East"),BorderLayout.EAST);
        janelaP.add(new JButton("West"),BorderLayout.WEST);
        janelaP.add(new JButton("Center"),BorderLayout.CENTER);

         //set do Frame (janelaP)
        janelaP.setBounds(500,500,500,500);
        janelaP.setDefaultCloseOperation(2); //conf para fechar a janela e interromper o programa
        janelaP.setVisible(true);
        
    
         
           
        

    }

    
}
