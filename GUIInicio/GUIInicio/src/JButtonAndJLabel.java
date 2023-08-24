import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class JButtonAndJLabel { //não vou usar extends;
    //Atrubutos
    int cont;
    public JButtonAndJLabel(){
        //criar um JFrame - Janela Básica para uma aplicação
        JFrame janela = new JFrame("Janela Principal");  //"janela" nome qualquer para o objeto
        JPanel painel = new JPanel(); //Painel(container)
        //adicionar o painel ao frame
        janela.getContentPane().add(painel);//adicionando o painel(container) dentro de outro container
        //criar componentes
        JButton button = new JButton("Clique aqui!!");
        JLabel text = new JLabel("Esperando clicar!!");
        //adicionar os componentes ao painel
        painel.add(button);
        painel.add(text);
       
        //configurações da janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //função fechar no botão " X "
        janela.pack();  //organiza o tamanho da janela.
        janela.setVisible(true);  //deixar a tela visivel
        //action Listener  (aão para o botão)
        button.addActionListener(e ->{  //criando a ação para o botão
            cont++; //adicionando contagem;
            painel.add(new JButton(""+cont));  //adicionar novo botão a cada clique
            text.setText("Nº de cliques "+cont);
            
            //  reconfiguar tamanho da janela a cada clique (  janela.pack();  )
        });

        


    }
}
