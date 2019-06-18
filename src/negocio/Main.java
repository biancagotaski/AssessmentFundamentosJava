package negocio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static DBConnection db = new DBConnection();
	static String input;
	static String cidade;
	static int pais;
	static String stopApplication = "3";
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		do {
			System.out.println("1. Cadastrar cidade \n"
					+ "2. Listar cidades\n"
					);
			
			input = scanner.nextLine();
				
			switch(input) {
				case "1":
					System.out.println("Escreva o nome da cidade: \n");
					cidade = scanner.nextLine();
					pais = escolherPais();
					cadastrar(cidade, pais);
					break;
				case "2":
					listarCidades();
					break;
				case "3":
					input = stopApplication;
					break;
			}
			System.out.println();
		} while(input != stopApplication);
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
