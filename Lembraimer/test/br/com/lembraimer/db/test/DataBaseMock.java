package br.com.lembraimer.db.test;

import br.com.lembraimer.db.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseMock {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1/lembraimer?useTimezone=true&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASS = "root";
    
    public static Connection conexao (){
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL,USER,PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
           throw new RuntimeException("Erro de conexao no banco", ex);
        }
    
    }
    
    public static void fecharConexao(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro na classe do con");
            }
        }
    }
    public static void fecharConexao(Connection con,PreparedStatement stmp){
        if(stmp!=null){
            try {
                stmp.close();
            } catch (SQLException ex) {
                System.out.println("Erro na classe do stmp");
            }
        }
    }
    public static void fecharfecharConexao(Connection con,PreparedStatement stmp, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro na classe do rs");
            }
        }
    }
    
}
