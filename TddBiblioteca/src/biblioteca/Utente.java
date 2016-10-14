package biblioteca;

import java.util.Map;
import java.util.TreeMap;

public class Utente {
	
	// ATTRIBUTI
	private String nome;
	private String cognome;
	private String cf;
	private Map<String,Libro> prestitiAttivi = new TreeMap<>();
	private Map<String,Libro> prestitiScaduti = new TreeMap<>();
	
	// COSTRUTTORI
	public Utente() {
	}

	public Utente(String nome, String cognome, String cf) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		
	}
	
	
	// METODI GET E SE
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public Map<String, Libro> getPrestitiAttivi() {
		return prestitiAttivi;
	}

	public void setPrestitiAttivi(Map<String, Libro> prestitiAttivi) {
		this.prestitiAttivi = prestitiAttivi;
	}

	public Map<String, Libro> getPrestitiScaduti() {
		return prestitiScaduti;
	}

	public void setPrestitiScaduti(Map<String, Libro> prestitiScaduti) {
		this.prestitiScaduti = prestitiScaduti;
	}

	
	
	

}
