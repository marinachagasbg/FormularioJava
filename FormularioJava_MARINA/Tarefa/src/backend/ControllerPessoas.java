/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import classes.Pessoa;

import backend.ControllerCidadeEstado;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author guilherme
 */
public class ControllerPessoas {
    
    static ControllerCidadeEstado controllerLugar = new ControllerCidadeEstado();
    
    static ConnectionDB database = new ConnectionDB();
    
    public static boolean InserePessoa(Pessoa pessoa){
        
        boolean retorno;
        
        pessoa.setCidadeID(controllerLugar.getCidadeID(pessoa.Cidade));
        pessoa.setEstadoID(controllerLugar.getEstadoID(pessoa.EstadoSigla));
        
        String sql = "INSERT INTO Pessoa (razao_social, nome_social, rua, numero, complemento, bairro, cep, email, telefone, id_estado, id_cidade)"
                + " VALUES ('"+pessoa.RazaoSocial+"','"+pessoa.NomeSocial+"','"+pessoa.Rua+"','"+pessoa.Numero+"','"+pessoa.Complemento+"','"+pessoa.Bairro+
                "','"+pessoa.CEP+"','"+pessoa.Email+"','"+pessoa.Telefone+"','"+pessoa.getCidadeID()+"','"+pessoa.getEstadoID()+"')";
        
        retorno = database.ExecutaSQL(sql);
          
        return retorno;
    }
}
