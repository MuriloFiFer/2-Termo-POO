// package app.Connection;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
// import java.util.List;

// import Model.Registro;

// /**
//  * VendasDAO
//  */
// public class VendasDAO {
//     // atributo
//     private Connection connection;
//     private List<Vendas> vendas;

//     // construtor
//     public VendasDAO() {
//         this.connection = ConnectionFactory.getConnection();
//     }

//     // criar Tabela
//     public void criaTabela() {
//         String sql = "CREATE TABLE IF NOT EXISTS vendas_lojavendas (produtos VARCHAR(255), Cliente VARCHAR(255), ValorVenda VARCHAR(255))";
//         try (Statement stmt = this.connection.createStatement()) {
//             stmt.execute(sql);
//             System.out.println("Tabela criada com sucesso.");

//         } catch (SQLException e) {
//             throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
//         } finally {
//             ConnectionFactory.closeConnection(this.connection);
//         }
//     }

//     // Listar todos os valores cadastrados
//     public List<Vendas> listarTodos() {
//         PreparedStatement stmt = null;
//         ResultSet rs = null;
//         vendas = new ArrayList<>();
//         try {
//             stmt = connection.prepareStatement("SELECT * FROM vendas_lojavendas");
//             rs = stmt.executeQuery();
//             while (rs.next()) {
//                 Vendas venda = new Vendas(
//                         rs.getString("produtos"),
//                         rs.getString("Cliente"),
//                         rs.getInt("ValorVenda"));
//                 vendas.add(venda);
//             }
//         } catch (SQLException ex) {
//             System.out.println(ex);
//         } finally {
//             ConnectionFactory.closeConnection(connection, stmt, rs);
//         }
//         return vendas;
//     }

//     // Cadastrar Venda no banco
//     public void cadastrar(String produtos, String cliente, String valorVenda) {
//         PreparedStatement stmt = null;
//         String sql = "INSERT INTO vendas_lojavendas (produtos, Cliente, ValorVenda) VALUES (?, ?, ?)";
//         try {
//             stmt = connection.prepareStatement(sql);
//             stmt.setString(1, produtos);
//             stmt.setString(2, cliente);
//             stmt.setInt(3, valorVenda);
//             stmt.executeUpdate();
//             System.out.println("Dados inseridos com sucesso");
//         } catch (SQLException e) {
//             throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
//         } finally {
//             ConnectionFactory.closeConnection(connection, stmt);
//         }
//     }

//     // Atualizar dados no banco
//     public void atualizar(String produtos, String cliente, String valorVenda) {
//         PreparedStatement stmt = null;
//         String sql = "UPDATE vendas_lojavendas SET Cliente = ?, ValorVenda = ? WHERE produtos = ?";
//         try {
//             stmt = connection.prepareStatement(sql);
//             stmt.setString(1, cliente);
//             stmt.setInt(2, valorVenda);
//             stmt.setString(3, produtos);
//             stmt.executeUpdate();
//             System.out.println("Dados atualizados com sucesso");
//         } catch (SQLException e) {
//             throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
//         } finally {
//             ConnectionFactory.closeConnection(connection, stmt);
//         }
//     }

//     // Apagar dados do banco
//     public void apagar(String produtos) {
//         PreparedStatement stmt = null;
//         String sql = "DELETE FROM vendas_lojavendas WHERE produtos = ?";
//         try {
//             stmt = connection.prepareStatement(sql);
//             stmt.setString(1, produtos);
//             stmt.executeUpdate();
//             System.out.println("Dado apagado com sucesso");
//         } catch (SQLException e) {
//             throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
//         } finally {
//             ConnectionFactory.closeConnection(connection, stmt);
//         }
//     }
// }
