package br.com.sustensoft.dao;

import br.com.sustensoft.util.ModuloConexao;
import br.com.sustensoft.modelo.LoginDTO;
import br.com.sustensoft.modelo.PrincipalDTO;
import br.com.sustensoft.visao.LoginTela;
import br.com.sustensoft.visao.PrincipalTela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Eletron
 */
public class LoginDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public boolean status;

    public boolean loginDAO(String login, String senha) {

        PrincipalDTO objPrincipalDTO = new PrincipalDTO();

        objPrincipalDTO.setLogin(login);
        objPrincipalDTO.setSenha1(senha);

        String sql = "select * from tbusuarios where login = ? and senha = ?";
        conexao = new ModuloConexao().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);

            pst.setString(1, objPrincipalDTO.getLogin());
            pst.setString(2, objPrincipalDTO.getSenha1());

            rs = pst.executeQuery();

            if (rs.next()) {
                PrincipalTela principal = new PrincipalTela(objPrincipalDTO);

                principal.setarUsuario(objPrincipalDTO.getLogin(), objPrincipalDTO.getSenha1());
                principal.setVisible(true);
                status = true;

            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)");
                status = false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ModuloConexao fechar = new ModuloConexao();
            fechar.closeConnection(conexao, pst, rs);
            
        }
        
        return status;

    }

    public LoginDAO() {
        conexao = ModuloConexao.conector();

    }

}
