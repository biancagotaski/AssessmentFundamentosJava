package negocio;

import java.io.FileInputStream;
import java.util.Properties;
import java.sql.*;

public class DBConnection {
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet result = null;
	static PreparedStatement prep = null;
	
	public static void listarCidades() throws SQLException {
		try {
			Properties p1 = new Properties();
			p1.load(new FileInputStream("connection.properties"));
			String user = p1.getProperty("user");
			String pssd = p1.getProperty("password");
			String url = p1.getProperty("jdbcurl");
			
			con = DriverManager.getConnection(url, user, pssd);
			
			stmt = con.createStatement();
			result = stmt.executeQuery("SELECT c.nome as `cidade`, p.nome as `pais` FROM cidade c, pais p\r\n" + 
					"WHERE p.idpais = c.id_pais;");
			
			while(result.next()) {
				System.out.println("Cidade: " + result.getString(1));
				System.out.println("País: " + result.getString(2));
				System.out.println("===============================================");
			}
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(result != null) {
				con.close();
			}
			if(stmt != null) {
				con.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
	public static void cadastrar(String cidade, int pais) throws SQLException {
		String sql = "INSERT INTO attfundamentos.cidade (nome, id_pais) VALUES(?,?)";
		
		try {
			Properties p1 = new Properties();
			p1.load(new FileInputStream("connection.properties"));
			String user = p1.getProperty("user");
			String pssd = p1.getProperty("password");
			String url = p1.getProperty("jdbcurl");
			
			con = DriverManager.getConnection(url, user, pssd);
			
			prep = con.prepareStatement(sql);
			prep.setString(1, cidade);
			prep.setInt(2, pais);
			prep.executeUpdate();
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(stmt != null) {
				con.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
}
