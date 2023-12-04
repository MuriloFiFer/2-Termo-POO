package Controller;

public package Controller;

import java.sql.Connection;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Produtos;
import app.Connection.ProdutosDAO;
import Model.Produtos;

import Model.Produtos;

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
            tableModel.addRow(new Object[] { produto.getPromocao(), produto.getCodBarra(),
                    produto.getQuantiProduto(), produto.getNomeProduto(), produto.getValor() }); // Changed from carro to produto
        }
    }

    // Método para cadastrar um novo produto no banco de dados
    public void cadastrar(int promocao, int codBarra, int quantiProduto, String nomeProduto, int valor) { // Changed from Int to int
        new ProdutosDAO().cadastrar(promocao, codBarra, quantiProduto, nomeProduto, valor); // Changed from CarrosDAO to ProdutosDAO
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de um produto no banco de dados
    public void atualizar(int promocao, int codBarra, int quantiProduto, String nomeProduto, int valor) { // Changed from Int to int
        new ProdutosDAO().atualizar(promocao, codBarra, quantiProduto, nomeProduto, valor); // Changed from CarrosDAO to ProdutosDAO
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um produto do banco de dados
    public void apagar(int codBarra) { // Changed from Int to int
        new ProdutosDAO().apagar(codBarra); // Changed from CarrosDAO to ProdutosDAO
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }

    public void cadastrar(String text, String text2) {
    }

    public void atualizar(String text, String text2) {
    }

    public void apagar(String text) {
    }
} ProdutoControl {
    
}
