package it.polito.tdp.anagrammi.model;
import java.util.*;

import it.polito.tdp.anagrammi.db.RicorsioneDAO;
public class Model {

	Ricorsione r = new Ricorsione();
	RicorsioneDAO ricorsioneDAO = new RicorsioneDAO();
	Set<String> corrette= new HashSet<String>();;
	Set<String> sbagliate = new HashSet<String>();;
	Set<String> anagrammi;
	Set<String> dizionario =  ricorsioneDAO.getDizionario();
	
	public void attivaCalcoloAnagramma(String input) {
		r.attivaCalcoloAnagramma(input);
	}

	
	
	public Set<String> getCorrette () {
	//	Set<String> dizionario =  ricorsioneDAO.getDizionario();
		anagrammi = (Set<String>) r.getAnagrammi();
		for(String s : anagrammi) {
			if(dizionario.contains(s))
				corrette.add(s);
		}	
		return corrette;
	}
	public Set<String> getSbagliate () {
	//	Set<String> dizionario = ricorsioneDAO.getDizionario();
		anagrammi = (Set<String>) r.getAnagrammi();
		for(String s : anagrammi) {
			if(!dizionario.contains(s))
				sbagliate.add(s);
		}
		
		return sbagliate;
	}
		
	public void pulusciListe() {
		this.corrette.clear();
		this.sbagliate.clear();
		this.anagrammi.clear();
		
	}
}
