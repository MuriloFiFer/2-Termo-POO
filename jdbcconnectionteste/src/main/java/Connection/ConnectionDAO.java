package Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDAO {
private Connection connection;

public ConnectionDAO() {
this.connection = ConnectionFactory.getConnection();
}

public void criarTabela() {
    String sql = "CREATE TABLE IF NOT EXISTS MINHA_TABELA (ID SERIAL PRIMARY KEY,NOME VARCHAR(255),EMAIL VARCHAR(255))";
    try (Statement stmt = connection.createStatement()) {
    stmt.execute(sql);
    System.out.println("Tabela criada com sucesso.");
    } catch (SQLException e) {
    throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
    } finally{  //"finally" para fechar a conexão idependente de erro ou não
    ConnectionFactory.closeConnection(this.connection);
    }   
    }

    public void apagarTabela() {
        String sql = "DROP TABLE MINHA_TABELA";
        try(Statement stmt = connection.createStatement()) {
        stmt.executeUpdate(sql);
        System.out.println("Tabela apagada com sucesso.");
        } catch (
        Exception e) {
        throw new RuntimeException("Erro ao apagar tabela.", e);
        }
        finally{  //"finally" para fechar a conexão idependente de erro ou não
        ConnectionFactory.closeConnection(this.connection);
        }
        }

        public void inserir(String nome, String email) {
            String sql = "INSERT INTO MINHA_TABELA (NOME, EMAIL) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate();
                System.out.println("Inserido com sucesso");
            } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
            } finally{
            ConnectionFactory.closeConnection(this.connection);
            }
            }

