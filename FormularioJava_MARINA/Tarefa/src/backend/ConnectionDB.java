package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;



public class ConnectionDB {
	
	//Conectar ao sgbd
	
	private Connection conectaDB(){ //(String database, String usuario, String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atividade7DB?useTimezone=true&serverTimezone=UTC", "root", "123");
			System.out.println("Conexão Realizada com Sucesso!!!");
			return conn;
			
		}catch(Exception e){
			System.out.println("Erro na conexão com a base de dados!!!");
			e.printStackTrace();
			return null;
		}
				
	}
	

	
	
	//Desconectar o sgbd	
	
	private void DesconectaDB(Connection conn) {
		
		try {
			if(conn != null){
				conn.close();
				System.out.println("Conexão Finalizada!");
			
			}
		}catch(Exception e){
			
			System.out.println("Erro na conexão com a base de dados!!!");
			e.printStackTrace();
		
		}
	}
	
	public ResultSet RetornaDadosSQL(String InstrucaoSQL){
		
		try {
			
			Connection con = conectaDB();
			Statement stmt = (Statement) con.createStatement();
			ResultSet res = stmt.executeQuery(InstrucaoSQL);
			//DesconectaDB(con);
			return res;
			
		}catch(Exception e) {
			System.out.println("Erro na execução da query SQL!!");
			return null;
		}
	}


	
	public boolean ExecutaSQL(String InstrucaoSQL){
			
			try {
				
				Connection con = conectaDB();
				Statement stmt = (Statement) con.createStatement();
				boolean res = stmt.execute(InstrucaoSQL);
				DesconectaDB(con);
				return true;
				
			}catch(Exception e) {
				System.out.println("Erro na execução da query SQL!!");
                                e.printStackTrace();
				return (false);
			}
		}
	
	
		
}