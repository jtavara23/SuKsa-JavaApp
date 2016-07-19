

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

    private Connection connection;

    final private String server;
    final private String database;
    final private String user;
    final private String pass;
    
    private String url;
    
    private Statement sentencia;
    private ResultSet resultado;
    private boolean conectado;
    
    public MySQL (String server, String database, String user, String pass) {
        this.server = server;
        this.database = database;
        this.user = user;
        this.pass = pass;
        this.conectado = false;
        conectar();
    }

    private void conectar () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://"+ server +"/" + database;
            connection = DriverManager.getConnection(url, user, pass);

            System.out.println("Conectado a " + url);
            conectado = true;
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error " + ex);
        }
    }

    public boolean ejecutar (String sql) {
        try {
            sentencia = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException e) {
            System.out.println("error " +  e);
            return false;
        }
        
        return true;
    }

    public boolean isConectado() {
        return conectado;
    }

    public ResultSet consultar (String sql) {
        try {
            sentencia = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultado;
    }
}
