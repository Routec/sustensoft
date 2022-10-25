package br.com.sustensoft.modelo;

/**
 *
 * @author Eletron
 */
public class PrincipalDTO {
    
    private String nome, sobrenome, cpf, fone, email, endereco, cep, login, senha1, senha2;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the usuario
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the usuario to set
     */
    public void setLogin(String login) {
        this.login = login;
        //System.out.println(this.usuario);
    }

    /**
     * @return the senha1
     */
    public String getSenha1() {
        return senha1;
    }

    /**
     * @param senha1 the senha to set
     */
    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }
    
    /**
     * @return the senha2
     */
    public String getSenha2() {
        return senha1;
    }

    /**
     * @param senha2 the senha to set
     */
    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }
    
    
}
