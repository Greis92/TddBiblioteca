package biblioteca;

import java.util.Date;

public class Prestito {

	// ATTRIBUTI
	private Utente u1;
	private Libro l1;
	private Date dataInizioPrestito;
	private Date dataFinePrestito;
	
	// COSTRUTTORI
	public Prestito(){
	}
	
	public Prestito(Utente u1, Libro l1, Date dataInizioPrestito, Date dataFinePrestito) {
		
		this.u1 = u1;
		this.l1 = l1;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataFinePrestito = dataFinePrestito;
		
	}
	
	// METODI GET E SET
	public Utente getU1() {
		return u1;
	}

	public void setU1(Utente u1) {
		this.u1 = u1;
	}

	public Libro getL1() {
		return l1;
	}

	public void setL1(Libro l1) {
		this.l1 = l1;
	}

	public Date getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(Date dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public Date getDataFinePrestito() {
		return dataFinePrestito;
	}

	public void setDataFinePrestito(Date dataFinePrestito) {
		this.dataFinePrestito = dataFinePrestito;
	}

	
	

}
