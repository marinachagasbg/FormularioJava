/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Marina
 */
public class PessoaJuridica extends Pessoa{
    public String CNPJ; 
    public String InscricaoEstadual; 
    public String InscricaoMunicipal; 
    public String Fax; 
    public String WebSite; 
    
    public void setPessoaJuridica(String CNPJ, String InscricaoEstadual, String InscricaoMunicipal, String Fax, String WebSite){
        this.CNPJ = CNPJ; 
        this. InscricaoEstadual = InscricaoEstadual; 
        this.InscricaoMunicipal = InscricaoMunicipal; 
        this.Fax = Fax; 
        this.WebSite = WebSite; 
    }
}
