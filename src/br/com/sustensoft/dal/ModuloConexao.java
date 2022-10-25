/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sustensoft.dal;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author Eletron
 */
public class ModuloConexao {

    /*
     * Metodo responsavel pela conexao com o BD
     *
     * @return conexao
     */
    public static Connection conector() {
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        //String driver = "com.mysql.jdbc.Driver";
        //String url = "jdbc:mysql://localhost:3306/dbsustensoft?characterEncoding=utf-8";
        String url = "jdbc:mysql://localhost:3306/dbsustensoft";
        String user = "dba";
        String password = "1234";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
