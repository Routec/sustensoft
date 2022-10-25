package br.com.sustensoft.util;

import java.sql.*;
import javax.swing.JOptionPane;

public class ModuloConexao {

    /*
     * Metodo responsavel pela conexao com o BD
     *
     * @return conexao
     */
    public static Connection conector() {
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbsustensoft";
        String user = "root";
        String password = "1234";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ModuloConexaoDAO" + e.getMessage());
            return null;
        }
    }

    public static void closeConnection(Connection conector) {
        try {
            if (conector != null) {
                conector.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }

    public static void closeConnection(Connection conector, PreparedStatement pst) {
        closeConnection(conector);
        try {
            if (pst != null) {
                pst.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }

    }
    
    public static void closeConnection(Connection conector, PreparedStatement pst, ResultSet rs) {
        closeConnection(conector, pst);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
}
