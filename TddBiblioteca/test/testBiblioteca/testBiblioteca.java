package testBiblioteca;

import static org.junit.Assert.*;

import org.junit.Test;

import biblioteca.Biblioteca;
import biblioteca.Gestione;
import biblioteca.Libro;
import biblioteca.Utente;
import biblioteca.UtenteGiaRegistrato;

public class testBiblioteca {

	@Test
	public void testUtente() {
		Utente u = new Utente("Aldo","Moro","111");
		assertNotNull(u);
		assertNotNull(u.getPrestitiAttivi());
	}
	
	@Test
	public void testLibro(){
		Libro l = new Libro("Fabio Volo", "Ciao ciao", "01", 20, 20);
		assertNotNull(l);
	}
	
	@Test
	public void testCreoBiblioteca(){
		Biblioteca b = new Biblioteca("Biblioteca Torino");
		assertNotNull(b);
		assertNotNull(b.getUtentiRegistrati());
		assertNotNull(b.getLibri());
	}

	@SuppressWarnings("unused")
	@Test
	public void testGestione() throws UtenteGiaRegistrato{
		Biblioteca b = new Biblioteca("Biblioteca Torino");
		Gestione g = new Gestione();
		int sizeUtenti1 = 0;
		int sizeUtenti2 = 0;
		
		// TEST REGISTRA UTENTE
		try{
			
			Utente u1 = g.registraUtente(b,"Paola","Chiara","000");
			sizeUtenti1 = b.getUtentiRegistrati().size();
			Utente u2 = g.registraUtente(b,"Paola","Chiara","000");
			sizeUtenti2 = b.getUtentiRegistrati().size();
			fail("Deve lanciare eccezione!");
		
		}catch(UtenteGiaRegistrato u){
			
			System.out.println(u.getMessage());
		
		}
		
		assertNotEquals("Devono essere uguali!", sizeUtenti1, sizeUtenti2);
		
		// TEST REGISTRA LIBRO
		Libro l1 = g.registraLibro(b,"Veronica Gilli", "Vento", "00", 10, 1);
		int tempCopie = l1.getCopieDisponibili();
		int tempCopie2 = l1.getCopieTotali();
		int tempSize = b.getLibri().size();
		
		g.registraLibro(b,"Veronica Gilli", "Vento", "00", 0, 1);
		
		assertNotEquals("Non devono essere uguali!", tempCopie, l1.getCopieDisponibili());
		assertNotEquals("Non devono essere uguali!", tempCopie2, l1.getCopieTotali());
		assertEquals("Devono essere uguali!", tempSize, b.getLibri().size());
		
		// TEST RICHIESTA PRESTITO
		Utente u4 = g.registraUtente(b,"Paola","Chiara","001");
		Utente u5 = g.registraUtente(b,"Pino","Albero","008");
		Utente u6 = g.registraUtente(b,"Gianni","Alberello","009");
		
		boolean prestitoAvvenuto1 = g.richiestaPrestito(b,u4,l1);
		assertTrue(prestitoAvvenuto1);
		
		boolean prestitoAvvenuto2 = g.richiestaPrestito(b, u5, l1);
		assertTrue(prestitoAvvenuto2);
		
		boolean prestitoAvvenuto3 = g.richiestaPrestito(b, u6, l1);
		assertFalse(prestitoAvvenuto3);
		
		// TEST RESTITUZIONE LIBRO 
		boolean libroRestituito1 = g.restituzioneLibro(b,u4,l1);
		assertTrue(libroRestituito1);
		
		u5.getPrestitiScaduti().put(l1.getSerialNum(), l1);
		boolean libroRestituito2 = g.restituzioneLibro(b,u4,l1);
		assertFalse(libroRestituito2);
		
	}
	
	
	

}
