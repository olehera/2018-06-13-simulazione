package it.polito.tdp.flightdelays;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.flightdelays.model.Airline;
import it.polito.tdp.flightdelays.model.Model;
import it.polito.tdp.flightdelays.model.Passeggero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FlightDelaysController {

	private Model model;
	
	public void setModel(Model model) {
		this.model = model;
		cmbBoxLineaAerea.getItems().addAll(this.model.caricaLinee());
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private ComboBox<Airline> cmbBoxLineaAerea;

    @FXML
    private Button caricaVoliBtn;

    @FXML
    private TextField numeroPasseggeriTxtInput;

    @FXML
    private TextField numeroVoliTxtInput;

    @FXML
    void doCaricaVoli(ActionEvent event) {
    	Airline linea = null;
		
		if (cmbBoxLineaAerea.getValue()==null) {
    		txtResult.setText("Devi selezionare una linea!");
    		return ;
    	} else 
    		linea = cmbBoxLineaAerea.getValue();
		
		model.creaGrafo(linea);
		
		txtResult.setText(model.peggioriRotte());
    }

    @FXML
    void doSimula(ActionEvent event) {
    	int passeggeri = 0;
    	int voli = 0;
		
		try {
    		passeggeri = Integer.parseInt(numeroPasseggeriTxtInput.getText().trim());
    	} catch(NullPointerException npe) {
    		txtResult.setText("Inserisci un numero intero in passeggeri!");
    		numeroPasseggeriTxtInput.clear();
    		return ;
    	}
		
		try {
    		voli = Integer.parseInt(numeroVoliTxtInput.getText().trim());
    	} catch(NullPointerException npe) {
    		txtResult.setText("Inserisci un numero intero in voli!");
    		numeroVoliTxtInput.clear();
    		return ;
    	}
		
		txtResult.appendText("\n\nSimulazione\n\n");
		for (Passeggero p: model.simula(passeggeri, voli))
			txtResult.appendText(p.getId()+" - "+p.getRitardo()+"\n");
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'FlightDelays.fxml'.";
        assert cmbBoxLineaAerea != null : "fx:id=\"cmbBoxLineaAerea\" was not injected: check your FXML file 'FlightDelays.fxml'.";
        assert caricaVoliBtn != null : "fx:id=\"caricaVoliBtn\" was not injected: check your FXML file 'FlightDelays.fxml'.";
        assert numeroPasseggeriTxtInput != null : "fx:id=\"numeroPasseggeriTxtInput\" was not injected: check your FXML file 'FlightDelays.fxml'.";
        assert numeroVoliTxtInput != null : "fx:id=\"numeroVoliTxtInput\" was not injected: check your FXML file 'FlightDelays.fxml'.";
    }
    
}