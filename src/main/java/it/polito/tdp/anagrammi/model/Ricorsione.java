package it.polito.tdp.anagrammi.model;

import it.polito.tdp.anagrammi.db.RicorsioneDAO;

import java.util.*;

public class Ricorsione {
	List<String> corrette = new LinkedList<String>();
	List<String> sbagliate = new LinkedList<String>();
	Set<String> anagrammi = new HashSet<String> ();
	
	RicorsioneDAO r = new RicorsioneDAO();
	
	public void attivaCalcoloAnagramma(String input) {
		anagramma_ricorsiva("", 0, input);
	}
	
	public void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {

		
		//caso terminale
		if(rimanenti.length()==0) {
			/*if(r.isCorretta(parziale)==true) {
				corrette.add(parziale);
			}else
				sbagliate.add(parziale);
			*/
			anagrammi.add(parziale);
			//System.out.println(parziale);
		
		}else {//caso normale
			for(int i=0; i<rimanenti.length();i++) {
				String newParziale = parziale + rimanenti.charAt(i);
				String newRimanenti = rimanenti.substring(0,i) + rimanenti.substring(i+1);
				anagramma_ricorsiva(newParziale, livello+1, newRimanenti);
			}
		}
		
	}
	
	public int dimensione (String s) {
		char []c = s.toCharArray();
		int fatt = 1;
		for(int i = 1; i<=c.length;i++) {
			fatt *= i;
		}
		return fatt;
	}
	
	public List<String> getCorrette() {
		return corrette;
	}

	public List<String> getSbagliate() {
		return sbagliate;
	}
	public Set<String> getAnagrammi() {
		return anagrammi;
	}
}
