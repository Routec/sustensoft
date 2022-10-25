/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sustensoft.modelo;

/**
 *
 * @author Eletron
 */
public class EnergiaDTO {

    private String login;
    private int consumo, pessoas, celesc, proprio, soma;
    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the pessoas
     */
    public int getPessoas() {
        return pessoas;
    }

    /**
     * @param pessoas the pessoas to set
     */
    public void setPessoas(int pessoas) {
        this.pessoas = pessoas;
    }
    
    /**
     * @return the consumo
     */
    public int getConsumo() {
        return consumo;
    }

    /**
     * @param consumo the consumo to set
     */
    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
  
    /**
     * @return the celesc
     */
    public int getCelesc() {
        return celesc;
    }

    /**
     * @param celesc the celesc to set
     */
    public void setCelesc(int celesc) {
        //this.celesc = celesc * (-800);
        this.celesc = celesc;
    }

    /**
     * @return the proprio
     */
    public int getProprio() {
        return proprio;
    }

    /**
     * @param proprio the proprio to set
     */
    public void setProprio(int proprio) {
        //this.proprio = proprio * (800);
        this.proprio = proprio;
    }

    public int getSoma(){
        return soma;
    }
    
    public void setSoma(int soma){
        soma = (consumo*(-1)) + (celesc*(-200)) + (proprio*(600)) + (pessoas*(500));
        this.soma = soma;
    }

}
