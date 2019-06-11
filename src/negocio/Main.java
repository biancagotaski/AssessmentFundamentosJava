package negocio;

import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String input;
	
	public static void main(String[] args) {
		menu();
		escolherPais();
	}
	
	public static String menu() {
		System.out.println("1. Cadastrar cidade \n"
				+ "2. Listar cidades"
				);
		input = scanner.nextLine();
		
		return input;
	}
	
	public static String escolherPais() {
		System.out.println("a) Brasil\n"
				+ "b) EUA\n"
				+ "c) Japão"
				);
		input = scanner.nextLine();
		
		return input;
	}
	
	public static String cadastrar(String cidade, String pais) {
		Pais p1 = new Pais();
		p1.setNome(pais);
		Cidade c1 = new Cidade();
		c1.setNome(cidade);
		c1.setPais(p1);
		
		//Faz a operação com o banco de dados...
		//Se tudo estiver ok:
		return "Cidade cadastrada com sucesso!";
		//senão retorna uma mensagem indicando que a cidade não foi cadastrada.
	}
	
	public static List<String> listarCidades(){
		List<String> cidades = null;
		return cidades;
	}
	
}
