package br.com.sustensoft.dao;

import br.com.sustensoft.util.ModuloConexao;
import br.com.sustensoft.modelo.PrincipalDTO;
import br.com.sustensoft.visao.PrincipalTela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class PrincipalDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    PrincipalDTO objPrincipalDTO;
    PrincipalTela objPrincipalTela;
    ModuloConexao objModuloConexaoDAO;

    public PrincipalDAO() { //Construtor
        conexao = ModuloConexao.conector();
        //abaAgua();
        objModuloConexaoDAO = new ModuloConexao();
        objPrincipalDTO = new PrincipalDTO();

    }

    public PrincipalDTO exibirUsuario(String login) {
        objPrincipalDTO.setLogin(login);

        String sql = "SELECT * FROM tbusuarios WHERE login = ?";
        conexao = new ModuloConexao().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objPrincipalDTO.getLogin());

            rs = pst.executeQuery();

            if (rs.next()) {

                //carregando os dados da variavel RS para o DTO
                objPrincipalDTO.setNome(rs.getString("nome"));
                objPrincipalDTO.setSobrenome(rs.getString("sobrenome"));
                objPrincipalDTO.setCpf(rs.getString("cpf"));
                objPrincipalDTO.setFone(rs.getString("fone"));
                objPrincipalDTO.setEmail(rs.getString("email"));
                objPrincipalDTO.setEndereco(rs.getString("endereco"));
                objPrincipalDTO.setCep(rs.getString("cep"));
                objPrincipalDTO.setLogin(rs.getString("login"));
                objPrincipalDTO.setSenha1(rs.getString("senha"));

                return objPrincipalDTO;

            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "'PrincipalDAO ExibirUsuario' " + e.getMessage());
        } finally {
            objModuloConexaoDAO.closeConnection(conexao, pst, rs);
        }
        return null;
    }

    public PrincipalDTO alterarUsuario(String login) {

        String sql = "UPDATE tbusuarios SET nome=?, sobrenome=?, cpf=?, fone=?, email=?, endereco=?, cep=?, login=?, senha=? WHERE login=?";

        conexao = new ModuloConexao().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objPrincipalDTO.getNome());
            pst.setString(2, objPrincipalDTO.getSobrenome());
            pst.setString(3, objPrincipalDTO.getCpf());
            pst.setString(4, objPrincipalDTO.getFone());
            pst.setString(5, objPrincipalDTO.getEmail());
            pst.setString(6, objPrincipalDTO.getEndereco());
            pst.setString(7, objPrincipalDTO.getCep());
            pst.setString(8, objPrincipalDTO.getLogin());
            pst.setString(9, objPrincipalDTO.getSenha1());
            pst.setString(10, login);

            pst.executeUpdate();

            if ((objPrincipalDTO.getNome().isEmpty()) || (objPrincipalDTO.getSobrenome().isEmpty()) || (objPrincipalDTO.getEmail().isEmpty()) || (objPrincipalDTO.getCep().isEmpty()) || (objPrincipalDTO.getLogin().isEmpty()) || (objPrincipalDTO.getSenha1().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Verifique se os campos: Nome, Sobrenome, email, CEP, Usuário e Senha estão preenchidos.");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário alterados com sucesso.");

                    return objPrincipalDTO;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "'PrincipalDAO AlterarUsuario' " + e.getMessage());
        } finally {
            objModuloConexaoDAO.closeConnection(conexao, pst);
        }
        return null;
    }

    public PrincipalDTO deletarUsuario(String login) {
        int confirma = JOptionPane.showConfirmDialog(null, "Se confirmado, o usuário será removido e o programa será encerrado imediatamente.", "Atenção", JOptionPane.YES_NO_OPTION);

        objModuloConexaoDAO = new ModuloConexao();
        conexao = new ModuloConexao().conector();

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM TBUSUARIOS WHERE LOGIN=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, login);
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso, o programa será encerrado.");

                    objPrincipalDTO.setNome(null);
                    objPrincipalDTO.setSobrenome(null);
                    objPrincipalDTO.setCpf(null);
                    objPrincipalDTO.setFone(null);
                    objPrincipalDTO.setEndereco(null);
                    objPrincipalDTO.setEmail(null);
                    objPrincipalDTO.setCep(null);
                    objPrincipalDTO.setLogin(null);
                    objPrincipalDTO.setSenha1(null);
                    objPrincipalDTO.setSenha2(null);

                    return objPrincipalDTO;

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                objModuloConexaoDAO.closeConnection(conexao, pst);
            }
        }

        return null;
    }

 }
