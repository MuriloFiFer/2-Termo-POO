package EstudoArrayList;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class ExemploHashMap {
    //atributos
    HashMap <String,String> capitalEstados = new HashMap<>();
    //Método
    public void teste(){
        capitalEstados.put("SP","São Paulo");
         capitalEstados.put("MG","Belo Horizonte");
          capitalEstados.put("RJ","Rio de Janeiro");
           capitalEstados.put("ES","Vitória");
           boolean jogo = true;
           while(jogo){
            String Estado = JOptionPane.showInputDialog("Digite a Sigla do Estado");
            JOptionPane.showMessageDialog(null, capitalEstados.get(Estado));
           }
    }

    public void nome(){
        pessoasIdade.put("Maria");
        pessoasIdade.put("João");
        for (String nome: pessoasIdade.keySet()){
            JOptionPane.showMessageDialog(null,"Nome: "+nome+", "+pessoasIdade.get(nome));
        }
        


    }
}
