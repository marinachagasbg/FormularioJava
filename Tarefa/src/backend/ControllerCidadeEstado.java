/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Connection;
import java.sql.ResultSet;


/**
 *
 * @author guilherme
 */
public class ControllerCidadeEstado {
    
    static ConnectionDB database = new ConnectionDB();
    
    
    public static boolean InsereEstado(String estado, String sigla){
        boolean retorno;
        
        String sql = "INSERT INTO estados (estado_nome, estado_sigla) VALUES ('"+estado+"','"+sigla+"')";
        System.out.println(sql);
        retorno = database.ExecutaSQL(sql);
        
        return retorno;
    }
    public static boolean InsereCidade(String cidade){
        boolean retorno;
		
        String sql = "INSERT INTO cidades (cidade_nome) VALUES ('" + cidade + "')";
        retorno = database.ExecutaSQL(sql);
      
        return retorno;
    }
    
}
