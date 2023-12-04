package app.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Clientes;

/**
 * ClientesDAO
 */
public class ClientesDAO {
    // atributo
    private Connection connection;
    private List<Clientes> clientes;

    // construtor
    public ClientesDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes_lojaclientes (CPF VARCHAR(11) PRIMARY KEY, NOME VARCHAR(255))";
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
    public List<Clientes> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        clientes = new ArrayList<>();
        // Cria uma lista para armazenar os clientes recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM clientes_lojaclientes");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Clientes com os valores do
                // registro

                Clientes cliente = new Clientes(
                        rs.getInt("cpf"),
                        rs.getString("nome"));
                clientes.add(cliente); // Adiciona o objeto Clientes à lista de clientes
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return clientes; // Retorna a lista de clientes recuperados do banco de dados
    }

    // Cadastrar Cliente no banco
    public void cadastrar(int cpf, String nome) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO clientes_lojaclientes (cpf, nome) VALUES (?, ?)";
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, cpf);
            stmt.setString(2, nome);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(int cpf, String nome) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pela cpf
        String sql = "UPDATE clientes_lojaclientes SET nome = ? WHERE cpf = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            // cpf é chave primaria não pode ser alterada.
            stmt.setInt(2, cpf);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(int cpf) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pela cpf
        String sql = "DELETE FROM clientes_lojaclientes WHERE cpf = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cpf);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {

            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}