package negocio;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String input;
	static DBConnection db = new DBConnection();
	
	public static void main(String[] args) {
		menu();
		String optionCidade = cadastrarCidade();
		int optionPais = escolherPais();
		listarCidades();
		cadastrar(optionCidade, optionPais);
	}
	
	public static String menu() {
		System.out.println("1. Cadastrar cidade \n"
				+ "2. Listar cidades"
				);
		
		input = scanner.nextLine();
			
		return input;
	}
	
	public static String cadastrarCidade() {
		System.out.println("Escreva o nome da cidade: \n");
		String cidade = scanner.nextLine();
		
		return cidade;
	}
	
	public static int escolherPais() {
		System.out.println("1. Brasil\n"
				+ "2. EUA\n"
				+ "3. Japão"
				);
		System.out.println("Selecione o país: \n");
		int selected = scanner.nextInt();
		
		switch(selected) {
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			default:
				return 0;
		}
	}
	
	public static void cadastrar(String cidade, int pais) {
		try {
			db.cadastrar(cidade, pais);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void listarCidades(){
		try {
			db.listarCidades();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
