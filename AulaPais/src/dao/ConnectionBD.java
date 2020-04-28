package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {

	static {
		try {
			
			System.out.println("Procurando Driver...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Encontrado");
			
		}catch(ClassNotFoundException ex) {
			System.out.println("Drive NÃO Encontrado");
			
			ex.printStackTrace();
		}
	}
	
	public static Connection conectar() {
		try {
			System.out.println("Estabelecendo Conexão...");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/AulaPais?useTimezone=true&serverTimezone=UTC","root", "K46c10jo");
			
			System.out.println("Conexão Estabelecida com Sucesso");
			
			return c;
		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;	
		}		
	}
}
