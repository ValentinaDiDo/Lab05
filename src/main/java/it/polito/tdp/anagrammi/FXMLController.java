package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.*;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model model;
	Set<String> sbagliate;
	Set<String> corrette;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private TextField txtInput;

    @FXML
    void handleCalcoloAngramma(ActionEvent event) {
    	String input = txtInput.getText();
    	model.attivaCalcoloAnagramma(input);
    	
    	corrette = this.model.getCorrette();
    	sbagliate = this.model.getSbagliate();
    	
    	String c = "";
    	for(String s : corrette) {
    		c += s+"\n";
    	}
    	String e = "";
    	for(String s : sbagliate) {
    		e += s+"\n";
    	}
    	txtCorretti.setText(c);
    	txtErrati.setText(e);
    
    	System.out.println(corrette.size() + sbagliate.size());
    	

    }

    @FXML
    void handleReset(ActionEvent event) {
    	txtInput.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    	corrette.clear();
    	sbagliate.clear();
    	this.model.pulusciListe();
    }

    @FXML
    void initialize() {
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		// TODO Auto-generated method stub
		this.model = model;
	}

}
