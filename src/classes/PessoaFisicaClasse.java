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
public class PessoaFisicaClasse extends Pessoa{
    public String CPF; 
    public String RG; 
    public String DataNascimento; 
    
    public void setPessoaFisica(String CPF, String RG, String DataNascimento){
        this.CPF = CPF;
        this.RG = RG;
        this.DataNascimento = DataNascimento;
    }
    
}
