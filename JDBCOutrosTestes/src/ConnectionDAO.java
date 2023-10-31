import java.sql.*;

import org.postgresql.core.ConnectionFactory;


public class ConnectionDAO {
    public void cleanup(){
        Connection con = ConnectionFactory.getConnection();
        Statement stmt = null;
        
            try {
                stmt.executeUpdate("drop table tbl_basica");
            } catch (Exception ex) {
                //ignorar todos os erros
            }
            con.Close();
            }
        

        public void diexemple() throws SQLException {
            Connection con = ConnectionFactory.getConnection();
            Statement stmt = null;
            System.out.println("\nExecutando os testes:");
            //Criar a tabela que armazena os dados
            stnt.executeUpdate("create table tbl_basica (a int2, b int2)");
        }
}
    

