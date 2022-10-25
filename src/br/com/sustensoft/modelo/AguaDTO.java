
package br.com.sustensoft.modelo;

/**
 *
 * @author Eletron
 */
public class AguaDTO {
    
    private String login;
    private int banho, sanitario, roupa, planta, carro, soma;
   
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
     * @return the banho
     */
    public int getBanho() {
        return banho;
    }

    /**
     * @param banho the banho to set
     */
    public void setBanho(int banho) {
        //this.banho = banho * (-100);
        this.banho = banho;
    }

    /**
     * @return the sanitario
     */
    public int getSanitario() {
        return sanitario;
    }

    /**
     * @param sanitario the sanitario to set
     */
    public void setSanitario(int sanitario) {
        //this.sanitario = sanitario * (-60);
        this.sanitario = sanitario;
    }

    /**
     * @return the roupa
     */
    public int getRoupa() {
        return roupa;
    }

    /**
     * @param roupa the roupa to set
     */
    public void setRoupa(int roupa) {
        //this.roupa = roupa * (-100);
        this.roupa = roupa;
    }

    /**
     * @return the planta
     */
    public int getPlanta() {
        return planta;
    }

    /**
     * @param planta the planta to set
     */
    public void setPlanta(int planta) {
        //this.planta = planta * (-100);
        this.planta = planta;
    }

    /**
     * @return the carro
     */
    public int getCarro() {
        return carro;
    }

    /**
     * @param carro the carro to set
     */
    public void setCarro(int carro) {
        //this.carro = carro * (-100);
        this.carro = carro;
    }
    
    public int getSoma(){
        return soma;
    }
    
    public void setSoma(int soma){
        soma = (banho*(-50)) + (sanitario*(-30)) + (roupa*(-50)) + (planta*(-50)) + carro*(-50);
        this.soma = soma;
    }
  
}
