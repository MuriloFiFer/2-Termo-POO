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
    private Connection connection;
    private List<Produtos> produtos;

    public ProdutosDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos_lojaprodutos (COD_BARRA VARCHAR(255), QUANTI_PRODUTO VARCHAR(255), NOME_PRODUTO VARCHAR(255) PRIMARY KEY, VALOR VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public List<Produtos> listarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        produtos = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM produtos_lojaprodutos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos produto = new Produtos(
                        rs.getString("cod_barra"),
                        rs.getString("quanti_produto"),
                        rs.getString("nome_produto"),
                        rs.getString("valor"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return produtos;
    }

    public void cadastrar(String codBarra, String quantiProduto, String nomeProduto, String valor) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO produtos_lojaprodutos (cod_barra, quanti_produto, nome_produto, valor) VALUES (?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codBarra);
            stmt.setString(2, quantiProduto);
            stmt.setString(3, nomeProduto);
            stmt.setString(4, valor);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void atualizar(String codBarra, String quantiProduto, String nomeProduto, String valor) {
        PreparedStatement stmt = null;
        String sql = "UPDATE produtos_lojaprodutos SET cod_barra = ?, quanti_produto = ?, valor = ? WHERE nome_produto = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codBarra);
            stmt.setString(2, quantiProduto);
            stmt.setString(3, valor);
            stmt.setString(4, nomeProduto);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void apagar(String codBarra) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM produtos_lojaprodutos WHERE nome_produto = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codBarra);
            stmt.executeUpdate();
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}
