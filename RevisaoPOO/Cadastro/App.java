package RevisaoPOO.Cadastro;

import javax.swing.JOptionPane;

import RevisaoPOO.Cadastro.Animal;

import RevisaoPOO.Cadastro.Agenda;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        //criar o cadastro (armazenar no vetor)
        Gato gatos[] = new Gato[10];
        Cachorro cachorros[] = new Cachorro[10];
        OutrosAnimais outros[] = new OutrosAnimais[10];
        int contGatos=0, contCachorros=0, contOutros=0, contAgenda=0;
        Agenda agendas[] = new Agenda[100]; //vetor para armazenar as consultas(obj)
        
       
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
                        //criar objeto
                    cachorros[contCachorros] = new Cachorro();
                    cachorros[contCachorros].setNome(JOptionPane.showInputDialog("Informe o nome do Pet:"));
                    cachorros[contCachorros].setraca(JOptionPane.showInputDialog("Informe a Raça do Pet:"));
                    cachorros[contCachorros].setProprietario(JOptionPane.showInputDialog("Informe o nome do Proprietário:"));
                    cachorros[contCachorros].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET:")));
                    contCachorros++;

                }
            else if(acao2==3){//Cadastro de outros Tipos de PET
                //criar o objeto
                outros[contOutros] = new OutrosAnimais();

                outros[contOutros].setNome(JOptionPane.showInputDialog("Informe o nome do Pet:"));
                    outros[contOutros].setraca(JOptionPane.showInputDialog("Informe a Raça do Pet:"));
                    outros[contOutros].setProprietario(JOptionPane.showInputDialog("Informe o nome do Proprietário:"));
                    outros[contOutros].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET:")));
                    contOutros++;
                }
              
  
    }else if(acao1==2){//agendar consulta
        //1º verificação - cadastro do nome
        boolean cadastroOK = false;
        String nomeAgenda = JOptionPane.showInputDialog("Informe o Nome do PET");
        for (int i = 0; i < contGatos; i++) {  // busca no vetor de gatos
            if(gatos[i].getNome().equals(nomeAgenda)){
                //mensage de confirmação
                JOptionPane.showMessageDialog(null,"Pet encontrado");
                cadastroOK = true;
                break;
            }       
        }
         for (int i = 0; i < contCachorros; i++) {  // busca no vetor de gatos
            if(cachorros[i].getNome().equals(nomeAgenda)){
                //mensage de confirmação
                JOptionPane.showMessageDialog(null,"Pet encontrado");
             cadastroOK = true;
                break;
            }          
        }
         for (int i = 0; i < contOutros; i++) {  // busca no vetor de gatos
            if(outros[i].getNome().equals(nomeAgenda)){
                //mensage de confirmação
                JOptionPane.showMessageDialog(null,"Pet encontrado");
            cadastroOK = true;
                break;
            }          
        }
        //2 Terminar o Cadastro
        if(cadastroOK){
boolean agendar = true;
            while(agendar){
                String dataAgenda = JOptionPane.showInputDialog("Informe a Data desejada:");
                String horaAgenda = JOptionPane.showInputDialog("Informe a Hora desejada:");
               
                if(contAgenda==0){
                    agendas[contAgenda] = new Agenda();
                    agendas[contAgenda].setData(dataAgenda);
                    agendas[contAgenda].setHora(horaAgenda);
                    agendar = false;
                }else{
                    for (int i = 0; i < contAgenda; i++) {
                        if(agendas[i].getDataHora().equals(dataAgenda+horaAgenda)){
                            //não pode agendar
                            break;
                        }                        
                    }
                }

                }
           
            }
        }



      //agendas[contAgendas] = new Agenda();
        //agendas[contAgendas].setData(JOptionPane.showInputDialog("Informe a Data desejada:"));
        //agendas[contAgendas].setHora(JOptionPane.showInputDialog("Informe a Hora desejada:"));
        //agendas[contAgendas].setServico(JOptionPane.showInputDialog("Informe o Serviço desejada:"));
        //contAgendas++;
      
           
       
else if (acao1 == 3) {
      break;                      
             } 

           }
                       
              
               
            }
        
        }
    


