package Controller;

import java.sql.Connection;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Produtos;
import app.Connection.ProdutosDAO;

/**
 * ProdutoControll
 */
public class ProdutoControl {
    // Atributos
    private List<Produtos> produtos; // Changed from carros to produtos
    private DefaultTableModel tableModel;
    private JTable table;

    // construtor
    public ProdutoControl(List<Produtos> produtos, DefaultTableModel tableModel, JTable table) {
        this.produtos = produtos; // Changed from carros to produtos
        this.tableModel = tableModel;
        this.table = table;
    }

    // metodos CRUD
    //////////////

    public static DefaultComboBoxModel<String> getProdutosComboModel() { // Changed from getCarrosComboModel to getProdutosComboModel
        DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
        comboModel.addElement("Selecione o Produto"); // Changed from Selecione o Carro to Selecione o Produto

        List<Produtos> produtos = new ProdutosDAO().listarTodos(); // Changed from CarrosDAO to ProdutosDAO
        for (Produtos produto : produtos) { // Changed from Carros to Produtos
            comboModel.addElement(produto.getMarca() + " " + produto.getModelo() + " " + produto.getPlaca()); // Changed from carro to produto
        }

        return comboModel;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {

        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        produtos = new ProdutosDAO().listarTodos(); // Changed from CarrosDAO to ProdutosDAO
        // Obtém os produtos atualizados do banco de dados
        for (Produtos produto : produtos) { // Changed from Carros to Produtos
            // Adiciona os dados de cada produto como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] {  produto.getCodBarra(),
                    produto.getQuantiProduto(), produto.getNomeProduto(), produto.getValor() }); // Changed from carro to produto
        }
    }

    // Método para cadastrar um novo produto no banco de dados
    public void cadastrar(String codBarra, String quantiProduto, String nomeProduto, String valor) { // Changed from String to String
        try {

            new ProdutosDAO().cadastrar( codBarra, quantiProduto, nomeProduto, valor); // Changed from CarrosDAO to ProdutosDAO
        // Chama o método de cadastro no banco de dados
        atualizarTabela();
        } catch (Exception e) {
           System.out.println("erro"); // TODO: handle exception
        }
         // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de um produto no banco de dados
    public void atualizar( String codBarra, String quantiProduto, String nomeProduto, String valor) { // Changed from String to String
        new ProdutosDAO().atualizar( codBarra, quantiProduto, nomeProduto, valor); // Changed from CarrosDAO to ProdutosDAO
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um produto do banco de dados
    public void apagar(String codBarra) { // Changed from String to String
        new ProdutosDAO().apagar(codBarra); // Changed from CarrosDAO to ProdutosDAO
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }


}
