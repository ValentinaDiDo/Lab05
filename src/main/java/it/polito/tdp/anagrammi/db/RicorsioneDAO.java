package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class RicorsioneDAO {

	public boolean isCorretta(String s) {
		String sql = "Select * " 
				+"from parola "
				+"where nome = ?";
		//List<String> ris = null;
		String parola = "";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,s);
			ResultSet rs = st.executeQuery();
			
			// ris = new LinkedList<String> ();
			while(rs.next()) {
				parola = rs.getString("nome");
			//	ris.add(parola);
			}
			st.close();
			rs.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Errore DAO");
		}
		//if(ris.size()!=0)
		if(parola.equals("") || parola.length()==0) {
			return false;}
		return true;
	}
	
	public Set<String> getDizionario (){
		Set<String> dizionario = new HashSet<String>();
		
		String sql = "select nome "
				+ "from parola";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				//AGGIUNGO PAROLE AL DIZIONARIO CHE USERO PER CONTROLLARE SE LA PAROLA è GIUSTA
				String parola = rs.getString("nome");
				dizionario.add(parola);
			}
			st.close();
			rs.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Errore DAO");
		}
		return  dizionario;
	}
}
