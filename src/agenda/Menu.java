package agenda;

/** Representação de uma interface para o usuário:
 *   agenda de contatos;
 *   interação com o usuário;
*
* Laboratório de Programação 2 - Lab 3.
* @author Gustavo Henrique Dias Ventura - 119110971.
*/


import java.util.Scanner;

public class Menu {
	//Atributos.
	/** Scanner para leitura de dados. */
	static Scanner sc = new Scanner(System.in);
	
	/** Objeto agenda para criação dos contatos. */
	static Agenda contatos = new Agenda();
	//Fim dos Atributos.
	
	//Início dos métodos.
	/** Lê os dados do usuário.
	 *  
	 * @param (String) interface para o usuário.
	 * 
	 * @return (String) dados do usuário.
	 */
	private static String ler(String menu) {
		System.out.print(menu);
		String entrada = sc.nextLine();
		return entrada;
	}
	
	/** Cadastra um contato na agenda:
	 *  Retorna true ou false se foi bem sucedido ou não.
	 *  Lê dados do usuário:
	 *   (int) posição;
	 *   (String) nome;
	 *   (String) sobrenome;
	 *   (String) telefone;
	 *  Verifica se a posição digitada é válida.
	 * 
	 * @return (boolean).
	 */
	public static boolean cadastrar() {
		String entrada = ler("\nPosição: ");
		if (entrada.trim().equals("") || Integer.parseInt(entrada) < 1 || Integer.parseInt(entrada) > 100) {
			System.out.println("POSIÇÃO INVÁLIDA!\n");
			return false;
		}
		
		int posicao = Integer.parseInt(entrada);
		String nome = ler("Nome: ");
		String sobrenome = ler("Sobrenome: ");
		String telefone = ler("Telefone: ");
		
		boolean cadastrado = contatos.cadastraContato(nome, sobrenome, telefone, posicao);
		if (cadastrado) {
			System.out.println("CADASTRO REALIZADO!\n");
			return true;
		}
		return false;
		
	}
	
	/** Retorna a representação de um contato pela posição digitada.
	 *  Lê a posição do contato.
	 */
	public static void verContato() {
		int posicao = Integer.parseInt(ler("Contato> "));
		System.out.println("\n" + contatos.exibirContato(posicao) + "\n");
	}
	//Fim dos métodos
	
	// Interface do usuário
	/** Main().
	 *  Interface para o usuário.
	 *  Trata as entradas verificando as opções existentes.
	 */
	public static void main(String[] args) {
		String menu = "(C)adastrar Contato\n"
				+ "(L)istar Contatos\n"
				+ "(E)xibir Contato\n"
				+ "(S)air\n\n"
				+ "Opção> ";
		
		while (true) {
			String entrada = ler(menu);
			
			if (entrada.equals("C")) {
				cadastrar();
			} else if (entrada.equals("E")) {
				verContato();
			} else if (entrada.equals("L")) {
				System.out.println(contatos.toString());
			} else if (entrada.equals("S")) {
				break;
			} else {
				System.out.println("OPÇÃO INVÁLIDA!\n");
			}
		}
	}
}
