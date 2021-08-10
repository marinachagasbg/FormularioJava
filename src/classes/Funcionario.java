/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.PessoaFisicaClasse;

/**
 *
 * @author Marina
 */
public class Funcionario extends PessoaFisicaClasse{
    public float Salario; 
    public String Comissao; 
    public String DataContratacao; 
    
    public void setFuncionario(float Salario, String Comissao, String DataContratacao){
        this.Salario = Salario; 
        this.Comissao = Comissao; 
        this.DataContratacao = DataContratacao; 
    }
}
