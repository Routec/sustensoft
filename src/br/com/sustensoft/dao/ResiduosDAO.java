/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sustensoft.dao;

import br.com.sustensoft.modelo.ResiduosDTO;
import br.com.sustensoft.util.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Eletron
 */
public class ResiduosDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    ResiduosDTO objResiduosDTO;
    
    public void conferirExistencia(ResiduosDTO objResiduosDTO){     //verifica a existencia de dados pre existentes em tabela energia, caso já exista algum valor cadastrado executa UPDATE, caso negativo realiza um ISERT
    
    String sql = "SELECT * FROM tbresiduo WHERE login = ?";   
        
        conexao = new ModuloConexao().conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objResiduosDTO.getLogin());
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                
                scoreUpdate(objResiduosDTO);       

            } 
                
                scoreAdicionar(objResiduosDTO);
                
                ModuloConexao.closeConnection(conexao, pst, rs);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "'ResiduosDAO ExibirConsumo' " + e.getMessage());
        } 
              
    }
    
    
    public void scoreAdicionar(ResiduosDTO objResiduosDTO){
        
        String sql = "INSERT INTO TBRESIDUO (login, organico, composteira, separacao, descarte) VALUES(?,?,?,?,?)";
        conexao = new ModuloConexao().conector();
           
        try {
            pst = conexao.prepareStatement(sql);
                        
            pst.setString(1, objResiduosDTO.getLogin());
            pst.setString(2, Integer.toString(objResiduosDTO.getOrganico()));
            pst.setString(3, Integer.toString(objResiduosDTO.getComposteira()));
            pst.setString(4, Integer.toString(objResiduosDTO.getSeparacao()));
            pst.setString(5, Integer.toString(objResiduosDTO.getDescarte()));
                                  
            pst.executeUpdate();
            
            ModuloConexao.closeConnection(conexao, pst);
            
            JOptionPane.showMessageDialog(null, "Dados do formulário Resíduos adicionados com sucesso.");
                        
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Cadastro EnergiaDAO" + e);
        }
    }
    
    
    public void scoreUpdate(ResiduosDTO objResiduosDTO) {
        String sql = "UPDATE tbresiduo SET organico=?, composteira=?, separacao=?, descarte=? WHERE login=?";

        conexao = new ModuloConexao().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Integer.toString(objResiduosDTO.getOrganico()));
            pst.setString(2, Integer.toString(objResiduosDTO.getComposteira()));
            pst.setString(3, Integer.toString(objResiduosDTO.getSeparacao()));
            pst.setString(4, Integer.toString(objResiduosDTO.getDescarte()));
            pst.setString(5, objResiduosDTO.getLogin());
            
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do formulário Resíduos atualizados com sucesso.");

                ModuloConexao.closeConnection(conexao, pst);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "'ResiduosDAO Update' " + e.getMessage());
        }

    }   //fechamento scoreUpdate
    
    
    public ResiduosDTO exibirResiduos(String login) {
        objResiduosDTO = new ResiduosDTO();
        objResiduosDTO.setLogin(login);

        String sql = "SELECT * FROM tbresiduo WHERE login = ?";
        conexao = new ModuloConexao().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objResiduosDTO.getLogin());

            rs = pst.executeQuery();

            if (rs.next()) {

                //carregando os dados da variavel RS para o DTO
                objResiduosDTO.setOrganico(rs.getInt("organico"));
                objResiduosDTO.setComposteira(rs.getInt("composteira"));
                objResiduosDTO.setSeparacao(rs.getInt("separacao"));
                objResiduosDTO.setDescarte(rs.getInt("descarte"));
                objResiduosDTO.setSoma(rs.getInt("soma"));
                objResiduosDTO.setLogin(rs.getString("login"));
                                
                return objResiduosDTO;

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, atualize os dados desta seção!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "'EnergiaDAO ExibirUsuario' " + e.getMessage());
        } finally {
            //objModuloConexaoDAO.closeConnection(conexao, pst, rs);
        }
        return null;
    }
        
}