/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author guilherme
 */
public class Pessoa {
    public String RazaoSocial;
    public String NomeSocial;
    public String Rua;
    public float Numero;
    public String Complemento;
    public String Bairro;
    public String CEP;
    public String Email;
    public String Telefone;
    public String EstadoSigla;
    public String Cidade;
    private int EstadoID;
    private int CidadeID;
    
    public void Pessoa(String RazaoSocial, String NomeSocial, String Rua, float Numero, String Complemento, String Bairro, String CEP, String Email, String Telefone, String EstadoSigla, String Cidade){
        this.RazaoSocial = RazaoSocial;
        this.NomeSocial = NomeSocial;
        this.Rua = Rua;
        this.Numero = Numero;
        this.Complemento = Complemento;
        this.Bairro = Bairro;
        this.CEP = CEP;
        this.Email = Email;
        this.Telefone = Telefone;
        this.EstadoSigla = EstadoSigla;
        this.Cidade = Cidade;
    }
    
    public void setEstadoID(int id){
        this.EstadoID = id;
    }
    
    public void setCidadeID(int id){
        this.CidadeID = id;
    }
    
    public int getEstadoID(){
        return (this.EstadoID);
    }
    public int getCidadeID(){
        return (this.CidadeID);
    }
    
    
    
    
}
