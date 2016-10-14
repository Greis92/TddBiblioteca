package biblioteca;

import java.util.Map;
import java.util.TreeMap;

public class Biblioteca {
	
	// ATTRIBUTI
	private String nome;
	private Map<String, Utente> utentiRegistrati = new TreeMap<>();
	private Map<String, Libro> libri = new TreeMap<>();
	private Map<String, Prestito> prestiti = new TreeMap<>();
	
	// COSTRUTTORI
	public Biblioteca() {
	}
	
	public Biblioteca(String nome) {
		this.nome = nome;
	}
	
	// METODI GET E SET
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<String, Utente> getUtentiRegistrati() {
		return utentiRegistrati;
	}

	public void setUtentiRegistrati(Map<String, Utente> utentiRegistrati) {
		this.utentiRegistrati = utentiRegistrati;
	}

	public Map<String, Libro> getLibri() {
		return libri;
	}

	public void setLibri(Map<String, Libro> libri) {
		this.libri = libri;
	}

	public Map<String, Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(Map<String, Prestito> prestiti) {
		this.prestiti = prestiti;
	}

	
	
	
	
	
	
	

}
