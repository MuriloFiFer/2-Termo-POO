package RevisaoPOO.Cadastro;

import javax.swing.JOptionPane;

import RevisaoPOO.Cadastro.Animal;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        //criar o cadastro (armazenar no vetor)
        Gato gatos[] = new Gato[10];
        Cachorro cachorros[] = new Cachorro[1];
        OutrosAnimais outros[] = new OutrosAnimais[10];
           int contGatos=0, contCachorros=0, contOutros=0;
       
        //criar a minha aplicação
        JOptionPane.showMessageDialog(null,"Bem-Vindo ao consultório\n do Dr. Frankstein");
        boolean aberto = true;
        while (aberto) {
            int acao1 = Integer.parseInt(JOptionPane.showInputDialog("\n1-Cadastro \n2-Consulta \n3-Sair"));
            if(acao1==1){//cadastro
                  
                int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1-Gato\n 2-Cachorro\n 3-Outro Animal"));
                if(acao2==1){//cadastro dos gatos
                    //criar um objeto
                    gatos[contGatos] = new Gato();  //utilizei o construtor
                    //gatos[contGatos].setNome(JOptionPane.showInputDialog("Informe o Nome dao seu Gato:"));
                    //setar os valores do cadastro
                    gatos[contGatos].setNome(JOptionPane.showInputDialog("Informe o nome do Pet"));
                    gatos[contGatos].setNome(JOptionPane.showInputDialog("Informe a Raça do Pet"));
                    gatos[contGatos].setProprietario(JOptionPane.showInputDialog("Informe o nome do Proprietário"));
                    gatos[contGatos].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
                    contGatos++;
                    
                }else if(acao2==2){//cadastro do cachorro
                    
                }else if(acao2==3){//Cadastro de outros Tipos de PET

                }
               // if (acao1 == 2) { // acessa uma conta já criada PJ
                    // localizar a conta no vetor
               //     int i; // contador
                //    int nAnimalBuscado = Integer.parseInt(JOptionPane.showInputDialog("Informe o nome do Gato"));
                //    boolean acesso = true;
                 //   for (i = 0; i < gatos.length; i++) {
                  //      if (nAnimalBuscado == gatos[i].getcontGatos()) {                                                          //parado aqui
                    //        JOptionPane.showMessageDialog(null, "Animal encontrado");
                      //      acesso = true;
                        //    break;
                      //  }
                     
                   // }
                    //JOptionPane.showMessageDialog(null,
                    //"Nome do Animal:" + gatos[i].getcontGatos());
                


            else if(acao1==2){//agendar consulta


            }
                
          
            
            }
           
            else if (acao1 == 3) {
                break;

        }
    
    }
}

}
