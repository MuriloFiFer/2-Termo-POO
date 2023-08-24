import java.awt.Frame;

public class FrameAWT extends Frame{   //Extenção que HERDA todos atributos da classe Frame;
    public FrameAWT(){
        super("Minha primeira janela AWT");  // Titulo da Janela
        this.setSize(600, 600);  //set do tamanho da janela;
        this.setVisible(true);  //deixando a janela visivel;
    }
    
}
