package Model;

import dao.ClientManager;

public class TestJDBC {
	public static void main(String[] args) {
		ClientManager.loadClientByID(1);
	}
	
	
}
