/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sustensoft.dao;

import br.com.sustensoft.util.ModuloConexao;
import br.com.sustensoft.modelo.AguaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author Eletron
 */
public class AguaDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    AguaDTO objAguaDTO;
           
    public void conferirExistencia(AguaDTO objAguaDTO){     //verifica a existencia de dados pre existentes em tabela agua, caso já exista algum valor cadastrado executa UPDATE, caso negativo realiza um ISERT
        
        String sql = "SELECT * FROM tbagua WHERE login = ?";   
        
        conexao = new ModuloConexao().conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objAguaDTO.getLogin());
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                
                scoreUpdate(objAguaDTO);       

            } 
                
                scoreAdicionar(objAguaDTO);
                
                ModuloConexao.closeConnection(conexao, pst, rs);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "'AguaDAO ExibirConsumo' " + e.getMessage());
        } 
              
    }
    
        
    public void scoreAdicionar(AguaDTO objAguaDTO){
        
        String sql = "INSERT INTO TBAGUA (login, banho, sanitario, roupa, planta, carro) VALUES(?,?,?,?,?,?)";
        conexao = new ModuloConexao().conector();
            
        try {
            pst = conexao.prepareStatement(sql);
                        
            pst.setString(1, objAguaDTO.getLogin());
            pst.setString(2, Integer.toString(objAguaDTO.getBanho()));
            pst.setString(3, Integer.toString(objAguaDTO.getSanitario()));
            pst.setString(4, Integer.toString(objAguaDTO.getRoupa()));
            pst.setString(5, Integer.toString(objAguaDTO.getPlanta()));
            pst.setString(6, Integer.toString(objAguaDTO.getCarro()));
            
            //System.out.println(pst);
            
            pst.executeUpdate();
            
            ModuloConexao.closeConnection(conexao, pst);
            
            JOptionPane.showMessageDialog(null, "Dados do formulário Água adicionados com sucesso.");
                        
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Cadastro AguaDAO" + e);
        }
    }
    
    
    
    public void scoreUpdate(AguaDTO objAguaDTO) {
        String sql = "UPDATE tbagua SET banho=?, sanitario=?, roupa=?, planta=?, carro=? WHERE login=?";

        conexao = new ModuloConexao().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Integer.toString(objAguaDTO.getBanho()));
            pst.setString(2, Integer.toString(objAguaDTO.getSanitario()));
            pst.setString(3, Integer.toString(objAguaDTO.getRoupa()));
            pst.setString(4, Integer.toString(objAguaDTO.getPlanta()));
            pst.setString(5, Integer.toString(objAguaDTO.getCarro()));
            pst.setString(6, objAguaDTO.getLogin());
            
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do formulário Água atualizados com sucesso.");

                ModuloConexao.closeConnection(conexao, pst);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "'AguaDAO Update' " + e.getMessage());
        }

    }   //fechamento scoreUpdate
    
    
    
    
    
    
    
    public AguaDTO exibirAgua(String login) {
        objAguaDTO = new AguaDTO();
                
        objAguaDTO.setLogin(login);

        String sql = "SELECT * FROM tbagua WHERE login = ?";
        conexao = new ModuloConexao().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objAguaDTO.getLogin());

            rs = pst.executeQuery();

            if (rs.next()) {

                //carregando os dados da variavel RS para o DTO
                objAguaDTO.setBanho(rs.getInt("banho"));
                objAguaDTO.setSanitario(rs.getInt("sanitario"));
                objAguaDTO.setRoupa(rs.getInt("roupa"));
                objAguaDTO.setPlanta(rs.getInt("planta"));
                objAguaDTO.setCarro(rs.getInt("carro"));
                objAguaDTO.setSoma(rs.getInt("soma"));
                objAguaDTO.setLogin(rs.getString("login"));
                
                
                return objAguaDTO;

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, atualize os dados desta seção!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "'PrincipalDAO ExibirUsuario' " + e.getMessage());
        } finally {
            //objModuloConexaoDAO.closeConnection(conexao, pst, rs);
        }
        return null;
    }
    
}
