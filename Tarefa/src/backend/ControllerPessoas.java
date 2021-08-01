/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import classes.Pessoa;

import backend.ControllerCidadeEstado;
import static backend.ControllerCidadeEstado.database;

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
    
    public static boolean InserePessoaFisica(Pessoa pessoa, String CPF, String RG, String DataNascimento){
        
        int id = 0;
        ResultSet resultado;
        boolean retorno;
        
        String sql = "SELECT id_pessoa From Pessoa WHERE email = '"+ pessoa.Email + "'";
        
        
        resultado = database.RetornaDadosSQL(sql);
          
         try {
            if(resultado != null){
                resultado.first();
                id = resultado.getInt("id_pessoa");
            } 	
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro, pessoa não existe!!");
            return false;
	}
        
        if (id != 0)
        {
            String sql2 = "INSERT INTO PessoaFisica (pessoa_fisica_cpf, pessoa_fisica_RG, pessoa_data_nasc, id_pessoa)" + 
                 " VALUES ('" + CPF +"','" + RG + "','" + DataNascimento + "','"+ id + "')";

            retorno = database.ExecutaSQL(sql2);
            return retorno;
        }
        
        return false;
        
    }
}
