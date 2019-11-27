
package Autenticador;

import java.io.Serializable;

public class Papel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	public Papel() {
	}

	public Papel(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
