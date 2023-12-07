package app.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Produtos;

/**
 * ProdutosDAO
 */
public class ProdutosDAO {
    // atributo
    private Connection connection;
    private List<Produtos> produtos;

    // construtor
    public ProdutosDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos_lojaprodutos (PROMOCAO VARCHAR(255), COD_BARRA VARCHAR(255), QUANTI_PRODUTO VARCHAR(255), NOME_PRODUTO VARCHAR(255) PRIMARY KEY, VALOR VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Produtos> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        produtos = new ArrayList<>();
        // Cria uma lista para armazenar os produtos recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM produtos_lojaprodutos");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Produtos com os valores do
                // registro

                Produtos produto = new Produtos(
                        rs.getString("promocao"),
                        rs.getString("cod_barra"),
                        rs.getString("quanti_produto"),
                        rs.getString("nome_produto"),
                        rs.getString("valor"));
                produtos.add(produto); // Adiciona o objeto Produtos à lista de produtos
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return produtos; // Retorna a lista de produtos recuperados do banco de dados
    }

    // Cadastrar Produto no banco
    public void cadastrar(String promocao, String codBarra, String quantiProduto, String nomeProduto, String valor) {
        try {
            String anoNumerico = promocao;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(" A promoção deve ser numérica");
        }
        try {
            String anoNumerico = valor;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(" O valor deve ser numérico");
        }
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT StringO produtos_lojaprodutos (promocao, cod_barra, quanti_produto, nome_produto, valor) VALUES (?, ?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, promocao);
            stmt.setString(2, codBarra);
            stmt.setString(3, quantiProduto);
            stmt.setString(4, nomeProduto);
            stmt.setString(5, valor);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(String promocao, String codBarra, String quantiProduto, String nomeProduto, String valor) {
        try {
            String anoNumerico = promocao;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(" A promoção deve ser numérica");
        }
        try {
            String anoNumerico = valor;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(" O valor deve ser numérico");
        }

        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pelo nomeProduto
        String sql = "UPDATE produtos_lojaprodutos SET promocao = ?, cod_barra = ?, quanti_produto = ?, valor = ? WHERE nome_produto = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, promocao);
            stmt.setString(2, codBarra);
            stmt.setString(3, quantiProduto);
            stmt.setString(4, valor);
            // nomeProduto é chave primária, não pode ser alterada.
            stmt.setString(5, nomeProduto);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String codBarra) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pelo nomeProduto
        String sql = "DELETE FROM produtos_lojaprodutos WHERE nome_produto = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codBarra);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}
