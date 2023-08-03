package Exception;

import javax.swing.JOptionPane;

public class ExemploThrow {
    
    public static void main(String[] args) {
        //digitação de senhas
       boolean testesenha = true;
       while (testesenha) {
        String loginUser = JOptionPane.showInputDialog("Informe Seu Login:");
         String dataNascimento = JOptionPane.showInputDialog("Informe sua data de nascimento [dd/mm/aa]:");  
         String senhaDigitada = JOptionPane.showInputDialog("Informe uma Senha de 6 Digitos:");  
         dataNascimento = dataNascimento.replace("/", ""); // Retirando   " / "  da data de nascimento para comparar com SENHA DIGITADA
              try{                
                if (senhaDigitada.length()!=6) {
                    throw new Exception("Senha Invalida"); //menssagem se houver a excessão
                }
                if (dataNascimento.equals(senhaDigitada)){
                throw new Exception("Senha não pode ser igual a data de nascimento!");
                }
                  if (senhaDigitada.equals(loginUser)){     //se senha for igual login digitado      //equals para comparar String
                 throw new Exception("Senha não pode ser igual Login");
               
                }
                 testesenha = false;
              }
              catch (Exception e) {
               
                
                JOptionPane.showMessageDialog(null, e.getMessage());
              }
        }
    }
  }



                                                                    
        
    

    
    
    


