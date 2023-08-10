package EstudoArrayList;

import java.util.ArrayList;

public class ExemploArrayList {
      //atributo
    //Declarando o ArrayList do Tipo String
    ArrayList<String> carros = new ArrayList<>();  //Nome do ArrayList "carros"
    //métodos
    public void teste() {
        //Adicionar Valores ao ArrayList
        carros.add("Uno");
        carros.add("Chevette");
        carros.add("Celta");
        carros.add("Monza");
        carros.add("Gol");
        //Imprimir toda a Lista
        System.out.println(carros);
        //Imprime posição 4 "Gol"
        System.out.println(carros.get(4));
        //percorrendo a lista com FOR
        for (int i = 0; i < carros.size(); i++) {  //percorrer ArrayList "size"
        System.out.println(carros.get(i));           
        }
        //percorrendo a lista com o FOR-EACH
        for (String i : carros) {
            System.out.println(i);
            
        }


        //apagar lista
        carros.clear();
        System.out.println(carros);
    }

    public void exercicio() {
        //criar um arraylist (Integer) + 5 valores
        
        ArrayList<String> numeros = new ArrayList<>();
        
        numeros.add("1");
        numeros.add("2");
        numeros.add("3");
        numeros.add("4");
        numeros.add("5");

        System.out.println(numeros);
    
        
    }
    }

