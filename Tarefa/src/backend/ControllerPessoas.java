/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import classes.Pessoa;
import classes.PessoaFisicaClasse;

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
    
    // Subrotina Pessoa Generica
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
    
    // Subrotina Pessoa Fisica
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
    
    // Subrotina Pessoa Juridica
    public static boolean InserePessoaJuridica(Pessoa pessoa, String CNPJ, String inscr_estadual, String inscr_munincipal, String fax, String website){
        
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
            String sql2 = "INSERT INTO PessoaJuridica (pessoa_juridica_cnpj, pessoa_juridica_insc_estadual, pessoa_juridica_insc_municipal, pessoa_juridica_fax, pessoa_juridica_website, id_pessoas)" + 
                 " VALUES ('" + CNPJ +"','" + inscr_estadual + "','" + inscr_munincipal + "','"+ fax + "','"+ website+"','" + id + "')";

            retorno = database.ExecutaSQL(sql2);
            return retorno;
        }
        
        return false;
        
    }
    
    // Subrotina Funcionario
    public static boolean InsereFuncionario(String CPF, String Salario, String Comissao, String DataContratacao){
       
        int id = 0;
        ResultSet result;
        boolean ret;
       
        String sql = "SELECT id_pessoa_fisica From PessoaFisica WHERE pessoa_fisica_cpf  = '"+ CPF + "'";
        System.out.print(sql);
       
        result = database.RetornaDadosSQL(sql);
         
         try {
            if(result != null){
                result.first();
                id = result.getInt("id_pessoa_fisica");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro, este funcionario não existe!!");
            return false;
}
       
        if (id != 0)
        {
            String sql2 = "INSERT INTO Funcionario (funcionario_salario, funcionario_comissao, funcionario_data_contratacao, id_pessoa_fisica)" +
                 " VALUES ('" + Salario +"','" + Comissao + "','" + DataContratacao + "','"+ id + "')";
            System.out.println(sql2);
            ret = database.ExecutaSQL(sql2);
            return ret;
        }
        return false;
       
    }
    
}
