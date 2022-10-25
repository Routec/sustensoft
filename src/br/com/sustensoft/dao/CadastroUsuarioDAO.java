package br.com.sustensoft.dao;

import br.com.sustensoft.util.ModuloConexao;
import br.com.sustensoft.modelo.PrincipalDTO;
import br.com.sustensoft.visao.CadastroUsuarioTela;
import br.com.sustensoft.visao.PrincipalTela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Eletron
 */
public class CadastroUsuarioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    
    
    public Boolean cadastrarUsuario(PrincipalDTO objPrincipalDTO) {
        
        
        
        String sqlConf = "SELECT * FROM tbusuarios WHERE login = ?";
        
        conexao = new ModuloConexao().conector();
        
        try {
            pst = conexao.prepareStatement(sqlConf);
            pst.setString(1, objPrincipalDTO.getLogin());
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "O login escolhido já encontra-se em uso, favor escolher outro!");
                                                       
            } 
            
            
                String sql = "insert into tbusuarios(nome, sobrenome, cpf, fone, email, endereco, cep, login, senha) VALUES(?,?,?,?,?,?,?,?,?)";

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

                //validacao dos campos obrigatorios
                if ((objPrincipalDTO.getNome().isEmpty()) || (objPrincipalDTO.getSobrenome().isEmpty())
                        || (objPrincipalDTO.getEmail().isEmpty()) || (objPrincipalDTO.getCep().isEmpty())
                        || (objPrincipalDTO.getLogin().isEmpty()) || (objPrincipalDTO.getSenha1().isEmpty())
                        || (objPrincipalDTO.getSenha2().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

                } else {
                    if ((objPrincipalDTO.getSenha1()).equals(objPrincipalDTO.getSenha2())) {
                        //a linha abaixco atualiza a tabela usuarios com os dados do formulario
                        //a estrutura abaixo é usada para confirmar a inserção dos dados na tabela
                        int adicionado = pst.executeUpdate();
                        if (adicionado > 0) {
                            JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");

                            CadastroUsuarioTela objCadastroUsuarioTela = new CadastroUsuarioTela();
                            objCadastroUsuarioTela.setVisible(false);

                            PrincipalTela principal = new PrincipalTela(objPrincipalDTO);
                            principal.setVisible(true);
                            return true;

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Preencha os campos 'Senha' com valores iguais");
                        return false;
                    }
                }


            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "CadastroUsuarioDAO" + e);
                
            }
            return false;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "'Cadastro Usuario DAO Verifica Login Existente:' " + e.getMessage());
            }
        
            return false;
        
    } 
    
    public CadastroUsuarioDAO() {
        conexao = ModuloConexao.conector();
    }
    
}   //fechamento classe

