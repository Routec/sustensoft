/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sustensoft.modelo;

/**
 *
 * @author Eletron
 */
public class ResiduosDTO {
    
    private String login;
    private int organico, composteira, separacao, descarte;
    private int soma;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getOrganico() {
        return organico;
    }

    public void setOrganico(int organico) {
        //this.organico = organico * 400;
        this.organico = organico;
    }

    public int getComposteira() {
        return composteira;
    }

    public void setComposteira(int composteira) {
        //this.composteira = composteira * 400;
        this.composteira = composteira;
    }

    public int getSeparacao() {
        return separacao;
    }

    public void setSeparacao(int separacao) {
        //this.separacao = separacao * 400;
        this.separacao = separacao;
    }

    public int getDescarte() {
        return descarte;
    }

    public void setDescarte(int descarte) {
        //this.descarte = descarte * 400;
        this.descarte = descarte;
    }
    
    public int getSoma(){
        return soma;
    }
    
    public void setSoma(int soma){
        /*
        int soma_1 = composteira ? 1 : 0;
        int soma_2 = separacao ? 1 : 0;
        int soma_3 = descarte ? 1 : 0;
        int soma_4 = organico ? 1 : 0;
        */
        
        soma = (organico*300)+(composteira*300)+(separacao*300)+(descarte*300);
        this.soma = soma;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
