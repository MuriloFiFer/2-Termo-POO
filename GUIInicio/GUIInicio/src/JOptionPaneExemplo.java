import javax.swing.JOptionPane;

public class JOptionPaneExemplo extends JOptionPane {
    public JOptionPaneExemplo (){
        super();
        String informacao = "Minha Janela Dialog";
        this.showMessageDialog(getComponentPopupMenu(),informacao, informacao, INFORMATION_MESSAGE); // information_message pode ser substituido por outras informações (simbuoos) .
         //ex:ERROR_MESSAGE, 1, 2 ou 3;

    }
    
}
