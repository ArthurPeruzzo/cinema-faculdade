package conexao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection connection;
    private final String URL = "jdbc:postgresql://localhost:5432/cinema";
    private final String USUARIO = "postgres";
    private final String SENHA = "postgres";
    private static Conexao instancia;

    private Conexao() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("conectou");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar... " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Problemas com driver... " + ex.getMessage());
        }
    }

    public static Conexao getConexao() {
        if(instancia == null){
            instancia = new Conexao();
        }
        return instancia;
    }


    public Connection getConnection() {
        return connection;
    }

}
