package agenda;

/** Representação de uma agenda de contatos:
 *   Lista de contatos.
 * 
 * Laboratório de Programação 2 - Lab 3.
 * @author Gustavo Henrique Dias Ventura - 119110971.
 */

import java.util.Arrays;

public class Agenda {
	//Atributos
	/** Array de contato para guardar os contatos:
	 *  Limite = 100.
	 */
	private Contato contatos[] = new Contato[100];
	//Fim dos Atributos
	
	//Início dos métodos
	/** Cadastra os contatos na lista de contatos.
	 *  Retorna true ou false se a operação for bem sucedida ou não.
	 * 
	 * @param (String) nome;
	 * @param (String) sobrenome;
	 * @param (String) telefone;
	 * @param (int) posição na lista.
	 * 
	 * @return (boolean).
	 */
	public boolean cadastraContato(String nome, String sobrenome, String telefone, int posicao) {
		if (posicao >= 1 && posicao <= 100) {
			contatos[posicao-1] = new Contato(nome, sobrenome, telefone);
			return true;
		}
		return false;
	}

	/** Retorna um contato pela posição, se não existir.
	 *  retorna que a posição é inválida.
	 *  
	 *  @param (int) posição do contato na lista.
	 *  
	 *  @return (String) nome sobrenome telefone ou POSIÇÃO INVÁLIDA!
	 */
	public String exibirContato(int posicao) {
		if (posicao >= 1 && posicao <= 100) {
			if (!(contatos[posicao-1] == null)) {
				return contatos[posicao-1].getNome() + " " + contatos[posicao-1].getSobrenome() + " - " + contatos[posicao-1].getTelefone();
			}
		}
		return "POSIÇÃO INVÁLIDA!";
	}

	/** Retorna uma string no estilo:
	 *  "posicao_1 - nome sobrenome;
	 *  		   .
	 *  		   .
	 *   posicao_n - nome sobrenome".
	 * 
	 *  @return (String) Retorna uma representação de todos os contatos.
	 */
	@Override
	public String toString() {
		String listagem = "";
		for (int posicao=0; posicao != 100; posicao++) {
			if (!(contatos[posicao] == null)) {
				listagem += posicao+1 + " - " + contatos[posicao].getNome() + " " + contatos[posicao].getSobrenome() + "\n";
			}
		}
		return listagem;
	}

	/** Override do hashCode.
	 * 
	 * @return (int).
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
		return result;
	}

	/** Override do equals:
	 *   verifica se dois contatos são iguais.
	 * 
	 * @param (Objeto).
	 * 
	 * @return (boolean).
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}
	//Fim dos métodos
}
