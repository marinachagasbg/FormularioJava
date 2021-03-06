/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Connection;
import java.sql.ResultSet;

public class ControllerCidadeEstado {
    
    static ConnectionDB database = new ConnectionDB();
    
    
    public static boolean InsereEstado(String estado, String sigla){
        boolean retorno;
        
        String sql = "INSERT INTO estados (estado_nome, estado_sigla) VALUES ('"+estado+"','"+sigla+"')";
        retorno = database.ExecutaSQL(sql);
        
        return retorno;
    }
    public static boolean InsereCidade(String cidade){
        boolean retorno;
		
        String sql = "INSERT INTO cidades (cidade_nome) VALUES ('" + cidade + "')";
        retorno = database.ExecutaSQL(sql);
      
        return retorno;
    }
    
    public static int getCidadeID(String nomeCidade){
        
        int id;
        ResultSet resultado;
        
        String sql = "SELECT id_cidades FROM cidades WHERE cidade_nome = '"+ nomeCidade +"'";
        resultado = database.RetornaDadosSQL(sql);
       
  
        
        try {
            if(resultado != null){
                resultado.first();
                id = resultado.getInt("id_cidades");
                return id;
            } 	
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro, cidade não existe!!");
	}
		
        return 0;
    }
    
    public static int getEstadoID(String siglaEstado){
    
        int id;
        ResultSet resultado;
        
        String sql = "SELECT id_estados FROM estados WHERE estado_sigla = '"+ siglaEstado +"'";
        resultado = database.RetornaDadosSQL(sql);
        
        try {
            if(resultado != null){
                resultado.first();
                id = resultado.getInt("id_estados");
                return id;
            } 	
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro, estado não existe!!");
	}
		
        return 0;
    }
    
    
    public static int updateEstado(String NovoNome, String NovaSigla){
        String sql = " update estado set estado_nome'"+ NovoNome +"', estado_sigla '" + NovaSigla +"' ";
        ResultSet resultado = database.RetornaDadosSQL(sql);
        
        try {
            if(resultado != null){
                resultado.first();
                int id = resultado.getInt("estados");
                return id;
            } 	
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro, cidade não existe!!");
	}
		
        return 0;
    }
    
    public static int deleteEstado(String NomeEstado){
        String sql = "delete from estados where estado_id "+ NomeEstado +";"; 
        
    
    ResultSet resultado = database.RetornaDadosSQL(sql);
        
        try {
            if(resultado != null){
                resultado.first();
                int id = resultado.getInt("estados");
                return id;
            } 	
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro, estado não existe!!");
	}	
        return 0;
    }
    
    public static int updateCidade(String NovoNome){
        String sql = " update estado set estado_nome'"+ NovoNome +"';";
        ResultSet resultado = database.RetornaDadosSQL(sql);
        
        try {
            if(resultado != null){
                resultado.first();
                int id = resultado.getInt("cidades");
                return id;
            } 	
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro, cidade não existe!!");
	}
		
        return 0;
    }
    
    public static int deleteCidade(String NomeCidade){
        String sql = "delete from estados where estado_id "+ NomeCidade +";"; 
        ResultSet resultado = database.RetornaDadosSQL(sql);
        
        try {
            if(resultado != null){
                resultado.first();
                int id = resultado.getInt("cidades");
                return id;
            } 	
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro, cidade não existe!!");
	}	
        return 0;
    }
}
