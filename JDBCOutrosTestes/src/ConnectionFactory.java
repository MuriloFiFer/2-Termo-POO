import java.sql.*;

/** ConnectionFactory */

public class ConnectionFactory {
    //atributos da conexão 
    private static final String url = "jdbc:postgres://localhost?5432/postgres";
     private static final String user= "postgres";
      private static final String pass = "postgres";
    
      public static Connection getConnection(){


        try{
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static void CloseConnection(Connecton con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }


           // Connection con; // conexão com o servidor de banco de dados
            // Cpnectar com o servidor de banco de dados
           // System.out.println("Conectando ao banco de dadis \nURL = " +url);
           // con = DriverManager.getConnection
        }
      

