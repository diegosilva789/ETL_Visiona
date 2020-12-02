package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exemplo","postgres","postgres");
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - Conexão" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Erro - Driver" + e.getMessage());
		} return con;
	}
	
//	private final String url = "jdbc:postgresql://localhost/exemplo";
//    private final String user = "postgres";
//    private final String password = "postgres";
//
//    public Connection connect() {
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to the PostgreSQL server successfully.");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return conn;
//    }
}
