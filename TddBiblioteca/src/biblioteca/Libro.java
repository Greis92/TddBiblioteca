package biblioteca;

public class Libro {
	
	// ATTRIBUTI
	private String autore;
	private String titolo;
	private String serialNum;
	private int copieTotali;
	private int copieDisponibili;
	
	
	// COSTRUTTORI
	public Libro() {
	}

	public Libro(String autore, String titolo, String serialNum, int copieTotali, int copieDisponibili) {
		
		this.autore = autore;
		this.titolo = titolo;
		this.serialNum = serialNum;
		this.copieTotali = copieTotali;
		this.copieDisponibili = copieDisponibili;
		
	}
	
	
	// METODI GET E SET
	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public int getCopieTotali() {
		return copieTotali;
	}

	public void setCopieTotali(int copieTotali) {
		this.copieTotali = copieTotali;
	}

	public int getCopieDisponibili() {
		return copieDisponibili;
	}

	public void setCopieDisponibili(int copieDisponibili) {
		this.copieDisponibili = copieDisponibili;
	}

	
	
	

}
