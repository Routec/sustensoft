/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sustensoft.dao;

import br.com.sustensoft.modelo.EnergiaDTO;
import br.com.sustensoft.util.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Eletron
 */
public class EnergiaDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    EnergiaDTO objEnergiaDTO;
    
    public void conferirExistencia(EnergiaDTO objEnergiaDTO){     //verifica a existencia de dados pre existentes em tabela energia, caso já exista algum valor cadastrado executa UPDATE, caso negativo realiza um ISERT
    
    String sql = "SELECT * FROM tbenergia WHERE login = ?";   
        
        conexao = new ModuloConexao().conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objEnergiaDTO.getLogin());
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                
                scoreUpdate(objEnergiaDTO);       

            } 
                
                scoreAdicionar(objEnergiaDTO);
                
                ModuloConexao.closeConnection(conexao, pst, rs);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "'EnergiaDAO ExibirConsumo' " + e.getMessage());
        } 
              
    }
    
    
    public void scoreAdicionar(EnergiaDTO objEnergiaDTO){
        
        String sql = "INSERT INTO TBENERGIA (login, consumo, celesc, proprio, pessoas) VALUES(?,?,?,?,?)";
        conexao = new ModuloConexao().conector();
           
        try {
            pst = conexao.prepareStatement(sql);
                        
            pst.setString(1, objEnergiaDTO.getLogin());
            pst.setString(2, Integer.toString(objEnergiaDTO.getConsumo()));
            pst.setString(3, Integer.toString(objEnergiaDTO.getCelesc()));
            pst.setString(4, Integer.toString(objEnergiaDTO.getProprio()));
            pst.setString(5, Integer.toString(objEnergiaDTO.getPessoas()));
            
            //System.out.println(pst);
                          
            pst.executeUpdate();
            
            ModuloConexao.closeConnection(conexao, pst);
            
            JOptionPane.showMessageDialog(null, "Dados do formulário Energia adicionados com sucesso.");
                        
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Cadastro EnergiaDAO" + e);
        }
    }
    
    
    public void scoreUpdate(EnergiaDTO objEnergiaDTO) {
        String sql = "UPDATE tbenergia SET consumo=?, celesc=?, proprio=?, pessoas=? WHERE login=?";

        conexao = new ModuloConexao().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Integer.toString(objEnergiaDTO.getConsumo()));
            pst.setString(2, Integer.toString(objEnergiaDTO.getCelesc()));
            pst.setString(3, Integer.toString(objEnergiaDTO.getProprio()));
            pst.setString(4, Integer.toString(objEnergiaDTO.getPessoas()));
            pst.setString(5, objEnergiaDTO.getLogin());
            
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do formulário Energia atualizados com sucesso.");

                ModuloConexao.closeConnection(conexao, pst);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "'EnergiaDAO Update' " + e.getMessage());
        }

    }   //fechamento scoreUpdate
    
    public EnergiaDTO exibirEnergia(String login) {
        objEnergiaDTO = new EnergiaDTO();
        objEnergiaDTO.setLogin(login);

        String sql = "SELECT * FROM tbenergia WHERE login = ?";
        conexao = new ModuloConexao().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objEnergiaDTO.getLogin());

            rs = pst.executeQuery();

            if (rs.next()) {

                //carregando os dados da variavel RS para o DTO
                objEnergiaDTO.setConsumo(rs.getInt("consumo"));
                objEnergiaDTO.setCelesc(rs.getInt("celesc"));
                objEnergiaDTO.setProprio(rs.getInt("proprio"));
                objEnergiaDTO.setPessoas(rs.getInt("pessoas"));
                objEnergiaDTO.setSoma(rs.getInt("soma"));
                objEnergiaDTO.setLogin(rs.getString("login"));
                
                return objEnergiaDTO;

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
