package biblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import DateUtility.DateUtility;

public class Gestione {

	/* METODO CHE REGISTRA L'UTENTE SE NON ESISTE
	 *	ALTRIMENTI LANCIA UN'ECCEZIONE
	 */	
	public Utente registraUtente(Biblioteca b, String nome, String cognome, String cf)throws UtenteGiaRegistrato {
		
		Utente u = null;
		
		if(b.getUtentiRegistrati().containsKey(cf)){
			
			throw new UtenteGiaRegistrato("");
		
		}
		
		u = new Utente(nome,cognome,cf);
		b.getUtentiRegistrati().put(cf, u);
		
		return u;
	}
	
	/* METODO CHE REGISTRA IL LIBRO SE NON ESISTE
	 *	ALTRIMENTI LANCIA UN'ECCEZIONE
	 */	
	public Libro registraLibro(Biblioteca b, String autore, String titolo, String serialNum, 
			int copieTotali, int copieDisponibili){
		
		Libro l = b.getLibri().get(serialNum);
		
		if(l != null){
			
			l.setCopieDisponibili(l.getCopieDisponibili()+copieDisponibili);
			l.setCopieTotali(l.getCopieTotali()+copieDisponibili);
			
		}
		
		l = new Libro(autore,titolo,serialNum,copieTotali,copieDisponibili);
		b.getLibri().put(serialNum, l);
		
		return l;
	}
	
	/* METODO CHE VERIFICA ALCUNE CONDIZIONI E POI CREA IL PRESTITO, 
	 * LO ATTIVA E RITORNA TRUE
	 * ALTRIMENTI RITORNA FALSE
	 */
	public boolean richiestaPrestito(Biblioteca b, Utente u, Libro l) {
		
		boolean prestitoAttivato = false;
		boolean lTemp = b.getLibri().containsKey(l.getSerialNum());
		
		if(lTemp == true && l.getCopieDisponibili() > 0 &&
		   b.getUtentiRegistrati().containsValue(u) &&
		   u.getPrestitiAttivi().size()< 3 && u.getPrestitiScaduti().size() == 0)
		{
			Prestito p = creaPrestito(l,u);
			prestitoAttivato = true;
			b.getPrestiti().put(l.getSerialNum(), p);
			u.getPrestitiAttivi().put(l.getSerialNum(), l);
			l.setCopieDisponibili(l.getCopieDisponibili()- 1);
		}
		
		return prestitoAttivato;
			
	}
	
	/* CREO UN OGGETTO PRESTITO CHE INIZIALIZZA LA DATA DEL PRESTITO E LA DATA DI SCADENZA
	 * AGGIORNA LA LISTA LIBRI UTENTE E RITORNA IL PRESTITO CREATO
	 */
	private Prestito creaPrestito(Libro l, Utente u){
		
		Prestito pTemp = null;
		DateUtility dt = new DateUtility();
		
		Date data = new Date(); // ASSEGNA LA DATA DI OGGI
		
		Calendar calendarCorrente = new GregorianCalendar();
		calendarCorrente.setTime(data); // DATA DI OGGI 
		Date dataCorrente = dt.convertCalendarToJavaDate(calendarCorrente); // CONVERTE DATA DA CALENDAR A DATE
		
		Calendar calendarScadenza = calendarCorrente;
		calendarScadenza.add(Calendar.MONTH, 1); // SET DATA DI OGGI AL MESE SUCCESSIVO
		Date dataScadenza = dt.convertCalendarToJavaDate(calendarScadenza); // CONVERTE DA DA CALENDAR A DATE
		
		pTemp = new Prestito(u,l,dataCorrente,dataScadenza);	
		
		return pTemp;
		
	}

	public boolean restituzioneLibro(Biblioteca b, Utente u, Libro l) {
		
		boolean libroRestituito = false;
		boolean lTemp = b.getLibri().containsKey(l.getSerialNum());
		boolean uTemp = b.getUtentiRegistrati().containsKey(u.getCf());
		Prestito pTemp = b.getPrestiti().get(l.getSerialNum());
		
		if(lTemp == true && uTemp == true && pTemp != null &&
		   u.getPrestitiAttivi().containsKey(l.getSerialNum()))
		{
			
			DateUtility dt = new DateUtility();
			Date dateTemp = new Date();
			Date dateFinePrestito = pTemp.getDataFinePrestito();
			long dayDiff = dt.getDayDifference(dateTemp, dateFinePrestito);
			
			if(dayDiff > 0){
				libroRestituito = true;
				u.getPrestitiAttivi().remove(l.getSerialNum());
				l.setCopieDisponibili(l.getCopieDisponibili()+1);
			}
			else{
				libroRestituito = true;
				u.getPrestitiAttivi().remove(l.getSerialNum());
				u.getPrestitiScaduti().put(l.getSerialNum(), l);
				l.setCopieDisponibili(l.getCopieDisponibili()+1);
			}
		}
		
		return libroRestituito;
		
	} 
	
}
