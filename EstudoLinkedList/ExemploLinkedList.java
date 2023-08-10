package EstudoLinkedList;

import java.util.LinkedList;

public class ExemploLinkedList {
    LinkedList <String> pessoas = new LinkedList<>();
//métodos
    public void teste () {
        pessoas.add("Maria");
        pessoas.add("Joana");
        pessoas.add("Pedro");
        //adicionando na primeira posição
        pessoas.addFirst("Ana");
        //Buscando a primeira posição
        System.out.println(pessoas.getFirst());


    }
}
