package dao;

import java.sql.*;

import Model.Client;

public class ClientManager {
	public static final String DB_LOGIN = "root";
	public static final String DB_PASSWD = "azerty";
	
	public static Client loadClientByID(int idClient) {
		Client result = new Client();
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banque", DB_LOGIN, DB_PASSWD);
			PreparedStatement stmt = con.prepareStatement("insert into client(nom, prenom, login, password) value('Pic', 'Maxime', 'mpic', 'azerty')");
			stmt.executeUpdate();
//			ResultSet rs = stmt.executeQuery();
//			
//			while(rs.next()) {
//				result.setIdClient(rs.getInt("idClient"));
//				result.setNom(rs.getString("nom"));
//				result.setPrenom(rs.getString("prenom"));
//				result.setLogin(rs.getString("login"));
//				
//				System.out.println("Trouvé un client" + result.toString());
//			}
			//rs.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
