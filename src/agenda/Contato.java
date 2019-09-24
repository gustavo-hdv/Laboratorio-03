package agenda;

/** Representação de um contato:
 *   nome;
 *   sobrenome;
 *   telefone;
 *   
 *   Laboratório de Programação 2 - Lab 3.
 *   @author Gustavo Henrique Dias Ventura - 119110971.
 */

public class Contato {
	//Atributos
	/** (String) nome. */
	private String nome;
	
	/** (String) sobrenome. */
	private String sobrenome;
	
	/** (String) telefone. */
	private String telefone;
	//Fim dos atributos
	
	//Construtor
	/** Construtor da classe:
	 *   recebe o nome, sobrenome e telefone do contato.
	 *  Tratamento de erro:
	 *   Não recebe parâmetros nulos ou ilegais.
	 * 
	 * @param (String) nome.
	 * @param (String) sobrenome.
	 * @param (String) telefone.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo!");
		}
		if (sobrenome == null) {
			throw new NullPointerException("Sobrenome nulo!");
		}
		if (telefone == null) {
			throw new NullPointerException("Telefone nulo!");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome vazio");
		}
		if (sobrenome.trim().equals("")) {
			throw new IllegalArgumentException("Sobrenome vazio");
		}
		if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("Telefone vazio");
		}
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	//Fim do construtor
	
	//Início dos métodos
	/** Retorna o nome do contato.
	 * 
	 * @return (String) nome.
	 */
	public String getNome() {
		return nome;
	}

	/** Retorna o sobrenome do contato.
	 * 
	 * @return (String) sobrenome.
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/** Retorna o telefone do contato.
	 * 
	 * @return (String) telefone.
	 */
	public String getTelefone() {
		return telefone;
	}

	/** Override do hashcode.
	 * 
	 * @return (int) .
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	/** Override do equals:
	 *   Compara nome e sobrenome dos contatos.
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
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	/** Override do toString.
	 *   Retorna uma string o estilo:
	 *   "nome sobrenome telefone".
	 *   
	 *  @return (String) representação de um contato.
	 */
	@Override
	public String toString() {
		return nome + " " + sobrenome + " " + telefone;
	}
	//Fim dos métodos
}
