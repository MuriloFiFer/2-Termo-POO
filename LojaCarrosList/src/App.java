import java.util.*; // importe geral da classe List(ArrayList..etc)

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // criar uma classe Carros - Atributos e os Métodos - OK
        // App
        // Criando Lista de Objetos
        List<Carros> listaCarros = new ArrayList<>();
        boolean aberto = true;
        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog(
                    "1-Cadastro de Carro\n2-Listar Carros\n3-Consultar Carro\n4-Remover carro da Lista"));
            if (acao == 1) { // 1- Cadasrar Carros na Lista
                // criar um bjeto
                String marcaCar = JOptionPane.showInputDialog(null, "Marca do Carro:");
                String modeloCar = JOptionPane.showInputDialog(null, "Modelo do Carro:");
                String anoCar = JOptionPane.showInputDialog(null, "Ano do Carro:");
                String corCar = JOptionPane.showInputDialog(null, "Cor do Carro:");
                // String placaCar = JOptionPane.showInputDialog(null, "Placa do Carro:");
                Carros car = new Carros(marcaCar, modeloCar, anoCar, corCar); // placaCar);
                listaCarros.add(car);
            } else if (acao == 2) { // 2- Listar os Carros cadastrados
                String listar = " ";
                for (Carros carros : listaCarros) {
                    listar += carros.imprimirLN();
                }
                JOptionPane.showMessageDialog(null, listar);
            } else if (acao == 3) { // 3- Consultar Carro
                String listar = " ";
                int i = 0;
                for (Carros carros : listaCarros) {
                    listar += i + carros.imprimirLN();
                    i++;
                }
                int acao2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha o Carro:\n" + listar));
                listaCarros.get(acao2).imprimir();
            } else if (acao == 4) { // 3- Remover Carro da lista
                String listar = "";
                int i = 0;
                for (Carros carros : listaCarros) {
                    listar += i + carros.imprimirLN();
                    i++;
                }
                int acao2 = Integer
                        .parseInt(JOptionPane.showInputDialog(null, "Escolha o Carro para Excluir:\n" + listar));
                listaCarros.get(acao2).imprimir();
                listaCarros.remove(acao2);
            }

        }

        // 1. Cadastrar Carros na Lista OK
        // 2. Listar os Carros OK
        // 3. Consultar Carro OK
        // 4. Apagar Carro

    }
}
